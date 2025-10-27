from Crypto.Random import get_random_bytes
from Crypto.Cipher import DES, AES
from Crypto.Util.Padding import pad,unpad

class AES_CIPHER_CBC:

    BLOCK_SIZE_AES = 16 # AES: Bloque de 128 bits

    def __init__(self, key):
        """Inicializa las variables locales"""
        self.key = key

    def cifrar(self, cadena, IV):
        """Cifra el parámetro cadena (de tipo String) con una IV específica, y
            devuelve el texto cifrado binario"""
        cipher = AES.new(self.key, AES.MODE_CBC, IV)
        padded = pad(cadena.encode(), self.BLOCK_SIZE_AES)
        cipher_text = cipher.encrypt(padded)
        return cipher_text

    def descifrar(self, cifrado, IV):
        """Descifra el parámetro cifrado (de tipo binario) con una IV específica, y
            devuelve la cadena en claro de tipo String"""
        decipher = AES.new(self.key, AES.MODE_CBC, IV)
        decipher_text = decipher.decrypt(cifrado)
        decipher_text = unpad(decipher_text, AES.block_size)
        return decipher_text.decode()

key_aes = get_random_bytes(16) # Clave aleatoria de 128 bits
IV_aes = get_random_bytes(16)  # IV aleatorio de 128 bits
datos = "Hola Amigos de Seguridad"
d = AES_CIPHER_CBC(key_aes)
cifrado = d.cifrar(datos, IV_aes)
descifrado = d.descifrar(cifrado, IV_aes)
print(cifrado)
print(descifrado)

datos = "Hola Amigas de Seguridad"
d = AES_CIPHER_CBC(key_aes)
cifrado = d.cifrar(datos, IV_aes)
descifrado = d.descifrar(cifrado, IV_aes)
print(cifrado)
print(descifrado)
############################
############################
############################

# Datos necesarios
key = get_random_bytes(8) # Clave aleatoria de 64 bits
IV = get_random_bytes(8)  # IV aleatorio de 64 bits para CBC
BLOCK_SIZE_DES = 8 # Bloque de 64 bits
data = "Hola amigos de la seguridad".encode("utf-8") # Datos a cifrar
print(data)
BLOCK_SIZE_AES = 16

# CIFRADO #######################################################################

# Creamos un mecanismo de cifrado DES en modo CBC con un vector de inicialización IV 
cipher = DES.new(key, DES.MODE_CBC, IV)
# Ciframos, haciendo que la variable “data” sea múltiplo del tamaño de bloque
ciphertext = cipher.encrypt(pad(data,BLOCK_SIZE_DES))
data = "Hola amigos de la seguridad".encode("utf-8") # Datos a cifrar
# Mostramos el cifrado por pantalla en modo binario
print(ciphertext)

# DESCIFRADO #######################################################################

# Creamos un mecanismo de (des)cifrado DES en modo CBC con un vector de inicialización IV para CBC
# Ambos, cifrado y descifrado, se crean de la misma forma
decipher_des = DES.new(key, DES.MODE_CBC, IV)
# Desciframos, eliminamos el padding, y recuperamos la cadena
new_data = unpad(decipher_des.decrypt(ciphertext), BLOCK_SIZE_DES).decode("utf-8", "ignore")
# Imprimimos los datos descifrados
print(new_data)

######################################################################################

mensaje = b"Hola Amigos de Seguridad"
key = get_random_bytes(16)

def pad(data):
    block_size = 16
    padding_len = block_size - len(data) % block_size
    padding = bytes([padding_len] * padding_len)
    return data + padding

def unpad(data):
    padding_len = data[-1]
    return data[:-padding_len]

# Imprimimos la clave y el mensaje original
print(f"Mensaje Original: {mensaje.decode('utf-8')}")
print(f"Clave (hex): {key.hex()}")
print("-" * 50)


# --- a. Modo de Operación ECB (Electronic Codebook) ---
print("## a. Modo ECB ##")
# Creamos el cifrador en modo ECB
cipher_ecb = AES.new(key, AES.MODE_ECB)
# Añadimos relleno y ciframos el mensaje
ciphertext_ecb = cipher_ecb.encrypt(pad(mensaje))
print(f"Texto Cifrado (hex): {ciphertext_ecb.hex()}")

# Para descifrar, creamos un nuevo objeto cifrador
decipher_ecb = AES.new(key, AES.MODE_ECB)
# Desciframos y quitamos el relleno
decrypted_message_ecb = unpad(decipher_ecb.decrypt(ciphertext_ecb))
print(f"Texto Descifrado: {decrypted_message_ecb.decode('utf-8')}")
print("-" * 50)


# --- b. Modo de Operación CTR (Counter) ---
print("## b. Modo CTR ##")
# El nonce debe tener un tamaño de la mitad del bloque (16/2 = 8 bytes)
nonce_ctr = get_random_bytes(8)
# Creamos el cifrador. El contador se inicializa automáticamente.
cipher_ctr = AES.new(key, AES.MODE_CTR, nonce=nonce_ctr)
# Ciframos el mensaje (no necesita padding)
ciphertext_ctr = cipher_ctr.encrypt(mensaje)
print(f"Nonce (hex): {nonce_ctr.hex()}")
print(f"Texto Cifrado (hex): {ciphertext_ctr.hex()}")

# Para descifrar, creamos un nuevo objeto cifrador con la misma clave y nonce
decipher_ctr = AES.new(key, AES.MODE_CTR, nonce=nonce_ctr)
decrypted_message_ctr = decipher_ctr.decrypt(ciphertext_ctr)
print(f"Texto Descifrado: {decrypted_message_ctr.decode('utf-8')}")
print("-" * 50)


# --- c. Modo de Operación OFB (Output Feedback) ---
print("## c. Modo OFB ##")
# Generamos un Vector de Inicialización (IV) aleatorio del tamaño del bloque (16 bytes)
iv_ofb = get_random_bytes(16)
# Creamos el cifrador
cipher_ofb = AES.new(key, AES.MODE_OFB, iv=iv_ofb)
# Ciframos el mensaje
ciphertext_ofb = cipher_ofb.encrypt(mensaje)
print(f"IV (hex): {iv_ofb.hex()}")
print(f"Texto Cifrado (hex): {ciphertext_ofb.hex()}")

# Para descifrar, usamos la misma clave e IV
decipher_ofb = AES.new(key, AES.MODE_OFB, iv=iv_ofb)
decrypted_message_ofb = decipher_ofb.decrypt(ciphertext_ofb)
print(f"Texto Descifrado: {decrypted_message_ofb.decode('utf-8')}")
print("-" * 50)


# --- d. Modo de Operación CFB (Cipher Feedback) ---
print("## d. Modo CFB ##")
# Generamos un IV aleatorio del tamaño del bloque (16 bytes)
iv_cfb = get_random_bytes(16)
# Creamos el cifrador
cipher_cfb = AES.new(key, AES.MODE_CFB, iv=iv_cfb)
# Ciframos el mensaje
ciphertext_cfb = cipher_cfb.encrypt(mensaje)
print(f"IV (hex): {iv_cfb.hex()}")
print(f"Texto Cifrado (hex): {ciphertext_cfb.hex()}")

# Para descifrar, usamos la misma clave e IV
decipher_cfb = AES.new(key, AES.MODE_CFB, iv=iv_cfb)
decrypted_message_cfb = decipher_cfb.decrypt(ciphertext_cfb)
print(f"Texto Descifrado: {decrypted_message_cfb.decode('utf-8')}")
print("-" * 50)


# --- e. Modo de Operación GCM (Galois/Counter Mode) ---
print("## e. Modo GCM ##")
# Generamos un nonce aleatorio del mismo tamaño del bloque (16 bytes)
nonce_gcm = get_random_bytes(16)
# Creamos el cifrador
cipher_gcm = AES.new(key, AES.MODE_GCM, nonce=nonce_gcm, mac_len=16)
# Ciframos y obtenemos el tag de autenticación
ciphertext_gcm, tag_gcm = cipher_gcm.encrypt_and_digest(mensaje)
print(f"Nonce (hex): {nonce_gcm.hex()}")
print(f"Texto Cifrado (hex): {ciphertext_gcm.hex()}")
print(f"Tag de Autenticación (hex): {tag_gcm.hex()}")

# Para descifrar, necesitamos la misma clave, nonce y el tag
decipher_gcm = AES.new(key, AES.MODE_GCM, nonce=nonce_gcm)
try:
    # Desciframos y verificamos la autenticidad
    decrypted_message_gcm = decipher_gcm.decrypt_and_verify(ciphertext_gcm, tag_gcm)
    print(f"Texto Descifrado: {decrypted_message_gcm.decode('utf-8')}")
    print("El mensaje es auténtico.")
except (ValueError, KeyError):
    print("El mensaje no es auténtico o está corrupto.")
print("-" * 50)
