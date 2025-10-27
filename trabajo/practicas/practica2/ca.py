import funciones_rsa as rsa

key_alice = "alice"
key_bob = "bob"

key_rsa_alice = rsa.crear_RSAKey()
key_rsa_bob = rsa.crear_RSAKey()

rsa.guardar_RSAKey_Privada("./alice.pem", key_rsa_alice, key_alice)
rsa.guardar_RSAKey_Privada("./bob.pem", key_rsa_bob, key_bob)

rsa.guardar_RSAKey_Publica("./alice.pub", key_rsa_alice)
rsa.guardar_RSAKey_Publica("./bob.pub", key_rsa_bob)

