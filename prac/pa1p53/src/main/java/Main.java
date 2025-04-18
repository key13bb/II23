import alturas.Mundo;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Mundo ps = new Mundo();
	ps.cargar("data/alturas.txt");
        System.out.println("\nPaíses por altura");
        Mundo.presentaEnConsola(ps.paisesPorAltura());
        System.out.println("\nNúmero de Países por continente");
        Mundo.presentaEnConsola(ps.numeroDePaisesPorContinente());
        System.out.println("\nPaíses por continente");
        Mundo.presentaEnConsola(ps.paisesPorContinente());
        System.out.println("\nPaíses por inciales");
        Mundo.presentaEnConsola(ps.paisesPorInicial());
        System.out.println("\nMedias de alturas por continente");
        Mundo.presentaEnConsola(ps.mediaPorContinente());
        System.out.println("\nContinentes con más países");
        System.out.println(ps.continentesConMasPaises());
		//--------------------------
        System.out.println("\nConjunto de países ordenados por altura");
        System.out.println(ps.paisesOrdenadosPorAltura());
        System.out.println("\nPaíses por continente ordenado por altura");
        Mundo.presentaEnConsola(ps.paisesPorContinenteAltura());
        System.out.println("\nPaíses por continente ordenados decrecientes en altura");
        Mundo.presentaEnConsola(ps.paisesPorContinenteAlturaDec());
    }
    
    /* SALIDA ESPERADA:
    
    Países por altura
    1.5	[Pais(Indonesia, Asia, 1.58)]
    1.6	[Pais(Bahrain, Asia, 1.651), Pais(Bolivia, South America, 1.6), Pais(Cambodia, Asia, 1.625), Pais(China, Asia, 1.67), Pais(Cuba, North America, 1.68), Pais(Ecuador, South America, 1.635), Pais(Gambia, Africa, 1.68), Pais(Ghana, Africa, 1.695), Pais(India, Asia, 1.647), Pais(Iraq, Asia, 1.654), Pais(Kazakhstan, Asia, 1.69), Pais(Korea North, Asia, 1.656), Pais(Malawi, Africa, 1.66), Pais(Malaysia, Asia, 1.663), Pais(Malta, Europe, 1.699), Pais(Mexico, North America, 1.67), Pais(Mongolia, Asia, 1.684), Pais(Nepal, Asia, 1.63), Pais(Nigeria, Africa, 1.638), Pais(Pakistan, Asia, 1.693), Pais(Panama, North America, 1.65), Pais(Paraguay, South America, 1.69), Pais(Peru, South America, 1.64), Pais(Philippines, Asia, 1.619), Pais(Saudi Arabia, Asia, 1.689), Pais(South Africa, Africa, 1.68), Pais(Sri Lanka, Asia, 1.636), Pais(Venezuela, South America, 1.69), Pais(Vietnam, Asia, 1.621)]
    1.7	[Pais(Albania, Europe, 1.74), Pais(Algeria, Africa, 1.722), Pais(Argentina, South America, 1.745), Pais(Australia, Oceania, 1.756), Pais(Austria, Europe, 1.792), Pais(Azerbaijan, Asia, 1.718), Pais(Belgium, Europe, 1.786), Pais(Brazil, South America, 1.731), Pais(Bulgaria, Europe, 1.752), Pais(Cameroon, Africa, 1.706), Pais(Canada, North America, 1.751), Pais(Chile, South America, 1.71), Pais(Colombia, South America, 1.706), Pais(Egypt, Africa, 1.703), Pais(Estonia, Europe, 1.791), Pais(Finland, Europe, 1.789), Pais(France, Europe, 1.756), Pais(Greece, Europe, 1.783), Pais(Hong Kong, Asia, 1.734), Pais(Hungary, Europe, 1.765), Pais(Iran, Asia, 1.703), Pais(Ireland, Europe, 1.775), Pais(Israel, Asia, 1.77), Pais(Italy, Europe, 1.765), Pais(Ivory Coast, Africa, 1.701), Pais(Jamaica, North America, 1.718), Pais(Japan, Asia, 1.707), Pais(Korea South, Asia, 1.735), Pais(Lebanon, Asia, 1.76), Pais(Libya, Africa, 1.713), Pais(Lithuania, Europe, 1.772), Pais(Luxembourg, Europe, 1.799), Pais(Mali, Africa, 1.713), Pais(Mauritamia, Africa, 1.72), Pais(Morocco, Africa, 1.727), Pais(New Zealand, Oceania, 1.77), Pais(Poland, Europe, 1.787), Pais(Portugal, Europe, 1.737), Pais(Qatar, Asia, 1.708), Pais(Romania, Europe, 1.72), Pais(Russia, Asia, 1.772), Pais(Senegal, Africa, 1.75), Pais(Singapore, Asia, 1.706), Pais(Slovakia, Europe, 1.794), Pais(Spain, Europe, 1.78), Pais(Sweden, Europe, 1.779), Pais(Switzerland, Europe, 1.754), Pais(Syria, Asia, 1.73), Pais(Taiwan, Asia, 1.714), Pais(Thailand, Asia, 1.703), Pais(Tonga, Oceania, 1.761), Pais(Tunisia, Africa, 1.723), Pais(Turkey, Euro/Asia, 1.74), Pais(Turkministan, Asia, 1.72), Pais(UAE, Asia, 1.734), Pais(Ukraine, Europe, 1.765), Pais(United Kingdom, Europe, 1.77), Pais(United States, North America, 1.763), Pais(Uruguay, South America, 1.7), Pais(Uzbekistan, Asia, 1.754)]
    1.8	[Pais(Bosnia & Herzegovina, Europe, 1.839), Pais(Croatia, Europe, 1.805), Pais(Czech Republic, Europe, 1.803), Pais(Denmark, Europe, 1.826), Pais(Germany, Europe, 1.81), Pais(Iceland, Europe, 1.81), Pais(Montenegro, Europe, 1.832), Pais(Netherlands, Europe, 1.838), Pais(Norway, Europe, 1.824), Pais(Serbia, Europe, 1.82), Pais(Slovenia, Europe, 1.803)]

    Número de Países por continente
    Africa	15
    Asia	32
    Euro/Asia	1
    Europe	34
    North America	6
    Oceania	3
    South America	10

    Países por continente
    Africa	[Pais(Algeria, Africa, 1.722), Pais(Cameroon, Africa, 1.706), Pais(Egypt, Africa, 1.703), Pais(Gambia, Africa, 1.68), Pais(Ghana, Africa, 1.695), Pais(Ivory Coast, Africa, 1.701), Pais(Libya, Africa, 1.713), Pais(Malawi, Africa, 1.66), Pais(Mali, Africa, 1.713), Pais(Mauritamia, Africa, 1.72), Pais(Morocco, Africa, 1.727), Pais(Nigeria, Africa, 1.638), Pais(Senegal, Africa, 1.75), Pais(South Africa, Africa, 1.68), Pais(Tunisia, Africa, 1.723)]
    Asia	[Pais(Azerbaijan, Asia, 1.718), Pais(Bahrain, Asia, 1.651), Pais(Cambodia, Asia, 1.625), Pais(China, Asia, 1.67), Pais(Hong Kong, Asia, 1.734), Pais(India, Asia, 1.647), Pais(Indonesia, Asia, 1.58), Pais(Iran, Asia, 1.703), Pais(Iraq, Asia, 1.654), Pais(Israel, Asia, 1.77), Pais(Japan, Asia, 1.707), Pais(Kazakhstan, Asia, 1.69), Pais(Korea North, Asia, 1.656), Pais(Korea South, Asia, 1.735), Pais(Lebanon, Asia, 1.76), Pais(Malaysia, Asia, 1.663), Pais(Mongolia, Asia, 1.684), Pais(Nepal, Asia, 1.63), Pais(Pakistan, Asia, 1.693), Pais(Philippines, Asia, 1.619), Pais(Qatar, Asia, 1.708), Pais(Russia, Asia, 1.772), Pais(Saudi Arabia, Asia, 1.689), Pais(Singapore, Asia, 1.706), Pais(Sri Lanka, Asia, 1.636), Pais(Syria, Asia, 1.73), Pais(Taiwan, Asia, 1.714), Pais(Thailand, Asia, 1.703), Pais(Turkministan, Asia, 1.72), Pais(UAE, Asia, 1.734), Pais(Uzbekistan, Asia, 1.754), Pais(Vietnam, Asia, 1.621)]
    Euro/Asia	[Pais(Turkey, Euro/Asia, 1.74)]
    Europe	[Pais(Albania, Europe, 1.74), Pais(Austria, Europe, 1.792), Pais(Belgium, Europe, 1.786), Pais(Bosnia & Herzegovina, Europe, 1.839), Pais(Bulgaria, Europe, 1.752), Pais(Croatia, Europe, 1.805), Pais(Czech Republic, Europe, 1.803), Pais(Denmark, Europe, 1.826), Pais(Estonia, Europe, 1.791), Pais(Finland, Europe, 1.789), Pais(France, Europe, 1.756), Pais(Germany, Europe, 1.81), Pais(Greece, Europe, 1.783), Pais(Hungary, Europe, 1.765), Pais(Iceland, Europe, 1.81), Pais(Ireland, Europe, 1.775), Pais(Italy, Europe, 1.765), Pais(Lithuania, Europe, 1.772), Pais(Luxembourg, Europe, 1.799), Pais(Malta, Europe, 1.699), Pais(Montenegro, Europe, 1.832), Pais(Netherlands, Europe, 1.838), Pais(Norway, Europe, 1.824), Pais(Poland, Europe, 1.787), Pais(Portugal, Europe, 1.737), Pais(Romania, Europe, 1.72), Pais(Serbia, Europe, 1.82), Pais(Slovakia, Europe, 1.794), Pais(Slovenia, Europe, 1.803), Pais(Spain, Europe, 1.78), Pais(Sweden, Europe, 1.779), Pais(Switzerland, Europe, 1.754), Pais(Ukraine, Europe, 1.765), Pais(United Kingdom, Europe, 1.77)]
    North America	[Pais(Canada, North America, 1.751), Pais(Cuba, North America, 1.68), Pais(Jamaica, North America, 1.718), Pais(Mexico, North America, 1.67), Pais(Panama, North America, 1.65), Pais(United States, North America, 1.763)]
    Oceania	[Pais(Australia, Oceania, 1.756), Pais(New Zealand, Oceania, 1.77), Pais(Tonga, Oceania, 1.761)]
    South America	[Pais(Argentina, South America, 1.745), Pais(Bolivia, South America, 1.6), Pais(Brazil, South America, 1.731), Pais(Chile, South America, 1.71), Pais(Colombia, South America, 1.706), Pais(Ecuador, South America, 1.635), Pais(Paraguay, South America, 1.69), Pais(Peru, South America, 1.64), Pais(Uruguay, South America, 1.7), Pais(Venezuela, South America, 1.69)]

    Países por inciales
    A	[Pais(Albania, Europe, 1.74), Pais(Algeria, Africa, 1.722), Pais(Argentina, South America, 1.745), Pais(Australia, Oceania, 1.756), Pais(Austria, Europe, 1.792), Pais(Azerbaijan, Asia, 1.718)]
    B	[Pais(Bahrain, Asia, 1.651), Pais(Belgium, Europe, 1.786), Pais(Bolivia, South America, 1.6), Pais(Bosnia & Herzegovina, Europe, 1.839), Pais(Brazil, South America, 1.731), Pais(Bulgaria, Europe, 1.752)]
    C	[Pais(Cambodia, Asia, 1.625), Pais(Cameroon, Africa, 1.706), Pais(Canada, North America, 1.751), Pais(Chile, South America, 1.71), Pais(China, Asia, 1.67), Pais(Colombia, South America, 1.706), Pais(Croatia, Europe, 1.805), Pais(Cuba, North America, 1.68), Pais(Czech Republic, Europe, 1.803)]
    D	[Pais(Denmark, Europe, 1.826)]
    E	[Pais(Ecuador, South America, 1.635), Pais(Egypt, Africa, 1.703), Pais(Estonia, Europe, 1.791)]
    F	[Pais(Finland, Europe, 1.789), Pais(France, Europe, 1.756)]
    G	[Pais(Gambia, Africa, 1.68), Pais(Germany, Europe, 1.81), Pais(Ghana, Africa, 1.695), Pais(Greece, Europe, 1.783)]
    H	[Pais(Hong Kong, Asia, 1.734), Pais(Hungary, Europe, 1.765)]
    I	[Pais(Iceland, Europe, 1.81), Pais(India, Asia, 1.647), Pais(Indonesia, Asia, 1.58), Pais(Iran, Asia, 1.703), Pais(Iraq, Asia, 1.654), Pais(Ireland, Europe, 1.775), Pais(Israel, Asia, 1.77), Pais(Italy, Europe, 1.765), Pais(Ivory Coast, Africa, 1.701)]
    J	[Pais(Jamaica, North America, 1.718), Pais(Japan, Asia, 1.707)]
    K	[Pais(Kazakhstan, Asia, 1.69), Pais(Korea North, Asia, 1.656), Pais(Korea South, Asia, 1.735)]
    L	[Pais(Lebanon, Asia, 1.76), Pais(Libya, Africa, 1.713), Pais(Lithuania, Europe, 1.772), Pais(Luxembourg, Europe, 1.799)]
    M	[Pais(Malawi, Africa, 1.66), Pais(Malaysia, Asia, 1.663), Pais(Mali, Africa, 1.713), Pais(Malta, Europe, 1.699), Pais(Mauritamia, Africa, 1.72), Pais(Mexico, North America, 1.67), Pais(Mongolia, Asia, 1.684), Pais(Montenegro, Europe, 1.832), Pais(Morocco, Africa, 1.727)]
    N	[Pais(Nepal, Asia, 1.63), Pais(Netherlands, Europe, 1.838), Pais(New Zealand, Oceania, 1.77), Pais(Nigeria, Africa, 1.638), Pais(Norway, Europe, 1.824)]
    P	[Pais(Pakistan, Asia, 1.693), Pais(Panama, North America, 1.65), Pais(Paraguay, South America, 1.69), Pais(Peru, South America, 1.64), Pais(Philippines, Asia, 1.619), Pais(Poland, Europe, 1.787), Pais(Portugal, Europe, 1.737)]
    Q	[Pais(Qatar, Asia, 1.708)]
    R	[Pais(Romania, Europe, 1.72), Pais(Russia, Asia, 1.772)]
    S	[Pais(Saudi Arabia, Asia, 1.689), Pais(Senegal, Africa, 1.75), Pais(Serbia, Europe, 1.82), Pais(Singapore, Asia, 1.706), Pais(Slovakia, Europe, 1.794), Pais(Slovenia, Europe, 1.803), Pais(South Africa, Africa, 1.68), Pais(Spain, Europe, 1.78), Pais(Sri Lanka, Asia, 1.636), Pais(Sweden, Europe, 1.779), Pais(Switzerland, Europe, 1.754), Pais(Syria, Asia, 1.73)]
    T	[Pais(Taiwan, Asia, 1.714), Pais(Thailand, Asia, 1.703), Pais(Tonga, Oceania, 1.761), Pais(Tunisia, Africa, 1.723), Pais(Turkey, Euro/Asia, 1.74), Pais(Turkministan, Asia, 1.72)]
    U	[Pais(UAE, Asia, 1.734), Pais(Ukraine, Europe, 1.765), Pais(United Kingdom, Europe, 1.77), Pais(United States, North America, 1.763), Pais(Uruguay, South America, 1.7), Pais(Uzbekistan, Asia, 1.754)]
    V	[Pais(Venezuela, South America, 1.69), Pais(Vietnam, Asia, 1.621)]

    Medias de alturas por continente
    Africa	1.7020666666666666
    Asia	1.6898750000000002
    Euro/Asia	1.74
    Europe	1.7841176470588234
    North America	1.7053333333333331
    Oceania	1.7623333333333333
    South America	1.6847

    Continentes con más países
    [Europe]

    Conjunto de países ordenados por altura
    [Pais(Indonesia, Asia, 1.58), Pais(Bolivia, South America, 1.6), Pais(Philippines, Asia, 1.619), Pais(Vietnam, Asia, 1.621), Pais(Cambodia, Asia, 1.625), Pais(Nepal, Asia, 1.63), Pais(Ecuador, South America, 1.635), Pais(Sri Lanka, Asia, 1.636), Pais(Nigeria, Africa, 1.638), Pais(Peru, South America, 1.64), Pais(India, Asia, 1.647), Pais(Panama, North America, 1.65), Pais(Bahrain, Asia, 1.651), Pais(Iraq, Asia, 1.654), Pais(Korea North, Asia, 1.656), Pais(Malawi, Africa, 1.66), Pais(Malaysia, Asia, 1.663), Pais(China, Asia, 1.67), Pais(Mexico, North America, 1.67), Pais(Cuba, North America, 1.68), Pais(Gambia, Africa, 1.68), Pais(South Africa, Africa, 1.68), Pais(Mongolia, Asia, 1.684), Pais(Saudi Arabia, Asia, 1.689), Pais(Kazakhstan, Asia, 1.69), Pais(Paraguay, South America, 1.69), Pais(Venezuela, South America, 1.69), Pais(Pakistan, Asia, 1.693), Pais(Ghana, Africa, 1.695), Pais(Malta, Europe, 1.699), Pais(Uruguay, South America, 1.7), Pais(Ivory Coast, Africa, 1.701), Pais(Egypt, Africa, 1.703), Pais(Iran, Asia, 1.703), Pais(Thailand, Asia, 1.703), Pais(Cameroon, Africa, 1.706), Pais(Colombia, South America, 1.706), Pais(Singapore, Asia, 1.706), Pais(Japan, Asia, 1.707), Pais(Qatar, Asia, 1.708), Pais(Chile, South America, 1.71), Pais(Libya, Africa, 1.713), Pais(Mali, Africa, 1.713), Pais(Taiwan, Asia, 1.714), Pais(Azerbaijan, Asia, 1.718), Pais(Jamaica, North America, 1.718), Pais(Mauritamia, Africa, 1.72), Pais(Romania, Europe, 1.72), Pais(Turkministan, Asia, 1.72), Pais(Algeria, Africa, 1.722), Pais(Tunisia, Africa, 1.723), Pais(Morocco, Africa, 1.727), Pais(Syria, Asia, 1.73), Pais(Brazil, South America, 1.731), Pais(Hong Kong, Asia, 1.734), Pais(UAE, Asia, 1.734), Pais(Korea South, Asia, 1.735), Pais(Portugal, Europe, 1.737), Pais(Albania, Europe, 1.74), Pais(Turkey, Euro/Asia, 1.74), Pais(Argentina, South America, 1.745), Pais(Senegal, Africa, 1.75), Pais(Canada, North America, 1.751), Pais(Bulgaria, Europe, 1.752), Pais(Switzerland, Europe, 1.754), Pais(Uzbekistan, Asia, 1.754), Pais(Australia, Oceania, 1.756), Pais(France, Europe, 1.756), Pais(Lebanon, Asia, 1.76), Pais(Tonga, Oceania, 1.761), Pais(United States, North America, 1.763), Pais(Hungary, Europe, 1.765), Pais(Italy, Europe, 1.765), Pais(Ukraine, Europe, 1.765), Pais(Israel, Asia, 1.77), Pais(New Zealand, Oceania, 1.77), Pais(United Kingdom, Europe, 1.77), Pais(Lithuania, Europe, 1.772), Pais(Russia, Asia, 1.772), Pais(Ireland, Europe, 1.775), Pais(Sweden, Europe, 1.779), Pais(Spain, Europe, 1.78), Pais(Greece, Europe, 1.783), Pais(Belgium, Europe, 1.786), Pais(Poland, Europe, 1.787), Pais(Finland, Europe, 1.789), Pais(Estonia, Europe, 1.791), Pais(Austria, Europe, 1.792), Pais(Slovakia, Europe, 1.794), Pais(Luxembourg, Europe, 1.799), Pais(Czech Republic, Europe, 1.803), Pais(Slovenia, Europe, 1.803), Pais(Croatia, Europe, 1.805), Pais(Germany, Europe, 1.81), Pais(Iceland, Europe, 1.81), Pais(Serbia, Europe, 1.82), Pais(Norway, Europe, 1.824), Pais(Denmark, Europe, 1.826), Pais(Montenegro, Europe, 1.832), Pais(Netherlands, Europe, 1.838), Pais(Bosnia & Herzegovina, Europe, 1.839)]

    Países por continente ordenado por altura
    Africa	[Pais(Nigeria, Africa, 1.638), Pais(Malawi, Africa, 1.66), Pais(Gambia, Africa, 1.68), Pais(South Africa, Africa, 1.68), Pais(Ghana, Africa, 1.695), Pais(Ivory Coast, Africa, 1.701), Pais(Egypt, Africa, 1.703), Pais(Cameroon, Africa, 1.706), Pais(Libya, Africa, 1.713), Pais(Mali, Africa, 1.713), Pais(Mauritamia, Africa, 1.72), Pais(Algeria, Africa, 1.722), Pais(Tunisia, Africa, 1.723), Pais(Morocco, Africa, 1.727), Pais(Senegal, Africa, 1.75)]
    Asia	[Pais(Indonesia, Asia, 1.58), Pais(Philippines, Asia, 1.619), Pais(Vietnam, Asia, 1.621), Pais(Cambodia, Asia, 1.625), Pais(Nepal, Asia, 1.63), Pais(Sri Lanka, Asia, 1.636), Pais(India, Asia, 1.647), Pais(Bahrain, Asia, 1.651), Pais(Iraq, Asia, 1.654), Pais(Korea North, Asia, 1.656), Pais(Malaysia, Asia, 1.663), Pais(China, Asia, 1.67), Pais(Mongolia, Asia, 1.684), Pais(Saudi Arabia, Asia, 1.689), Pais(Kazakhstan, Asia, 1.69), Pais(Pakistan, Asia, 1.693), Pais(Iran, Asia, 1.703), Pais(Thailand, Asia, 1.703), Pais(Singapore, Asia, 1.706), Pais(Japan, Asia, 1.707), Pais(Qatar, Asia, 1.708), Pais(Taiwan, Asia, 1.714), Pais(Azerbaijan, Asia, 1.718), Pais(Turkministan, Asia, 1.72), Pais(Syria, Asia, 1.73), Pais(Hong Kong, Asia, 1.734), Pais(UAE, Asia, 1.734), Pais(Korea South, Asia, 1.735), Pais(Uzbekistan, Asia, 1.754), Pais(Lebanon, Asia, 1.76), Pais(Israel, Asia, 1.77), Pais(Russia, Asia, 1.772)]
    Euro/Asia	[Pais(Turkey, Euro/Asia, 1.74)]
    Europe	[Pais(Malta, Europe, 1.699), Pais(Romania, Europe, 1.72), Pais(Portugal, Europe, 1.737), Pais(Albania, Europe, 1.74), Pais(Bulgaria, Europe, 1.752), Pais(Switzerland, Europe, 1.754), Pais(France, Europe, 1.756), Pais(Hungary, Europe, 1.765), Pais(Italy, Europe, 1.765), Pais(Ukraine, Europe, 1.765), Pais(United Kingdom, Europe, 1.77), Pais(Lithuania, Europe, 1.772), Pais(Ireland, Europe, 1.775), Pais(Sweden, Europe, 1.779), Pais(Spain, Europe, 1.78), Pais(Greece, Europe, 1.783), Pais(Belgium, Europe, 1.786), Pais(Poland, Europe, 1.787), Pais(Finland, Europe, 1.789), Pais(Estonia, Europe, 1.791), Pais(Austria, Europe, 1.792), Pais(Slovakia, Europe, 1.794), Pais(Luxembourg, Europe, 1.799), Pais(Czech Republic, Europe, 1.803), Pais(Slovenia, Europe, 1.803), Pais(Croatia, Europe, 1.805), Pais(Germany, Europe, 1.81), Pais(Iceland, Europe, 1.81), Pais(Serbia, Europe, 1.82), Pais(Norway, Europe, 1.824), Pais(Denmark, Europe, 1.826), Pais(Montenegro, Europe, 1.832), Pais(Netherlands, Europe, 1.838), Pais(Bosnia & Herzegovina, Europe, 1.839)]
    North America	[Pais(Panama, North America, 1.65), Pais(Mexico, North America, 1.67), Pais(Cuba, North America, 1.68), Pais(Jamaica, North America, 1.718), Pais(Canada, North America, 1.751), Pais(United States, North America, 1.763)]
    Oceania	[Pais(Australia, Oceania, 1.756), Pais(Tonga, Oceania, 1.761), Pais(New Zealand, Oceania, 1.77)]
    South America	[Pais(Bolivia, South America, 1.6), Pais(Ecuador, South America, 1.635), Pais(Peru, South America, 1.64), Pais(Paraguay, South America, 1.69), Pais(Venezuela, South America, 1.69), Pais(Uruguay, South America, 1.7), Pais(Colombia, South America, 1.706), Pais(Chile, South America, 1.71), Pais(Brazil, South America, 1.731), Pais(Argentina, South America, 1.745)]

    Países por continente ordenados decrecientes en altura
    Africa	[Pais(Senegal, Africa, 1.75), Pais(Morocco, Africa, 1.727), Pais(Tunisia, Africa, 1.723), Pais(Algeria, Africa, 1.722), Pais(Mauritamia, Africa, 1.72), Pais(Mali, Africa, 1.713), Pais(Libya, Africa, 1.713), Pais(Cameroon, Africa, 1.706), Pais(Egypt, Africa, 1.703), Pais(Ivory Coast, Africa, 1.701), Pais(Ghana, Africa, 1.695), Pais(South Africa, Africa, 1.68), Pais(Gambia, Africa, 1.68), Pais(Malawi, Africa, 1.66), Pais(Nigeria, Africa, 1.638)]
    Asia	[Pais(Russia, Asia, 1.772), Pais(Israel, Asia, 1.77), Pais(Lebanon, Asia, 1.76), Pais(Uzbekistan, Asia, 1.754), Pais(Korea South, Asia, 1.735), Pais(UAE, Asia, 1.734), Pais(Hong Kong, Asia, 1.734), Pais(Syria, Asia, 1.73), Pais(Turkministan, Asia, 1.72), Pais(Azerbaijan, Asia, 1.718), Pais(Taiwan, Asia, 1.714), Pais(Qatar, Asia, 1.708), Pais(Japan, Asia, 1.707), Pais(Singapore, Asia, 1.706), Pais(Thailand, Asia, 1.703), Pais(Iran, Asia, 1.703), Pais(Pakistan, Asia, 1.693), Pais(Kazakhstan, Asia, 1.69), Pais(Saudi Arabia, Asia, 1.689), Pais(Mongolia, Asia, 1.684), Pais(China, Asia, 1.67), Pais(Malaysia, Asia, 1.663), Pais(Korea North, Asia, 1.656), Pais(Iraq, Asia, 1.654), Pais(Bahrain, Asia, 1.651), Pais(India, Asia, 1.647), Pais(Sri Lanka, Asia, 1.636), Pais(Nepal, Asia, 1.63), Pais(Cambodia, Asia, 1.625), Pais(Vietnam, Asia, 1.621), Pais(Philippines, Asia, 1.619), Pais(Indonesia, Asia, 1.58)]
    Euro/Asia	[Pais(Turkey, Euro/Asia, 1.74)]
    Europe	[Pais(Bosnia & Herzegovina, Europe, 1.839), Pais(Netherlands, Europe, 1.838), Pais(Montenegro, Europe, 1.832), Pais(Denmark, Europe, 1.826), Pais(Norway, Europe, 1.824), Pais(Serbia, Europe, 1.82), Pais(Iceland, Europe, 1.81), Pais(Germany, Europe, 1.81), Pais(Croatia, Europe, 1.805), Pais(Slovenia, Europe, 1.803), Pais(Czech Republic, Europe, 1.803), Pais(Luxembourg, Europe, 1.799), Pais(Slovakia, Europe, 1.794), Pais(Austria, Europe, 1.792), Pais(Estonia, Europe, 1.791), Pais(Finland, Europe, 1.789), Pais(Poland, Europe, 1.787), Pais(Belgium, Europe, 1.786), Pais(Greece, Europe, 1.783), Pais(Spain, Europe, 1.78), Pais(Sweden, Europe, 1.779), Pais(Ireland, Europe, 1.775), Pais(Lithuania, Europe, 1.772), Pais(United Kingdom, Europe, 1.77), Pais(Ukraine, Europe, 1.765), Pais(Italy, Europe, 1.765), Pais(Hungary, Europe, 1.765), Pais(France, Europe, 1.756), Pais(Switzerland, Europe, 1.754), Pais(Bulgaria, Europe, 1.752), Pais(Albania, Europe, 1.74), Pais(Portugal, Europe, 1.737), Pais(Romania, Europe, 1.72), Pais(Malta, Europe, 1.699)]
    North America	[Pais(United States, North America, 1.763), Pais(Canada, North America, 1.751), Pais(Jamaica, North America, 1.718), Pais(Cuba, North America, 1.68), Pais(Mexico, North America, 1.67), Pais(Panama, North America, 1.65)]
    Oceania	[Pais(New Zealand, Oceania, 1.77), Pais(Tonga, Oceania, 1.761), Pais(Australia, Oceania, 1.756)]
    South America	[Pais(Argentina, South America, 1.745), Pais(Brazil, South America, 1.731), Pais(Chile, South America, 1.71), Pais(Colombia, South America, 1.706), Pais(Uruguay, South America, 1.7), Pais(Venezuela, South America, 1.69), Pais(Paraguay, South America, 1.69), Pais(Peru, South America, 1.64), Pais(Ecuador, South America, 1.635), Pais(Bolivia, South America, 1.6)]

	*/
}



