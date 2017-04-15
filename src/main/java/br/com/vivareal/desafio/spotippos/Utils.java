package br.com.vivareal.desafio.spotippos;

/**
 * Funcoes genericas auxiliares.
 */
public class Utils {
    /**
     * Retorna se uma coordenada está em um range de pontos.
     * */
    public static Boolean isInRange(Integer x, Integer y, Integer upperLeftX, Integer upperLeftY, Integer bottomRightX, Integer bottomRightY) {
        return (x > upperLeftX && x < bottomRightX && y > bottomRightY && y < upperLeftY);
    }

}
