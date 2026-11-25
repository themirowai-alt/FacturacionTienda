/**
 * Calcula el importe final a cobrar a un cliente de la tienda.
 *
 * <p>Sobre el subtotal (precio por unidades) se aplica, por este orden, el
 * descuento según el tipo de cliente, el recargo de envío y el IVA.</p>
 *
 * @author Adrian
 * @version 1.0
 */
public final class FacturacionTienda {

    private static final int CLIENTE_ESTUDIANTE = 1;
    private static final int CLIENTE_JUBILADO = 2;
    private static final int CLIENTE_VIP = 3;

    private static final double DESCUENTO_ESTUDIANTE = 0.10;
    private static final double DESCUENTO_JUBILADO = 0.15;
    private static final double DESCUENTO_VIP = 0.05;
    private static final double RECARGO_ENVIO = 4.95;
    private static final double FACTOR_IVA = 1.21;

    private FacturacionTienda() {
        // Clase de utilidad: no se instancia.
    }

    /**
     * Punto de entrada: muestra por consola un cálculo de ejemplo.
     *
     * @param args argumentos de línea de comandos (no se utilizan)
     */
    public static void main(final String[] args) {
        // Prueba de funcionamiento:
        // precioBase = 100.0, unidades = 2, tipoCliente = 1 (estudiante), conEnvio = true
        final double resultado = calcularImporteFinal(100.0, 2, CLIENTE_ESTUDIANTE, true);
        System.out.println("Importe total a pagar: " + resultado);
    }

    /**
     * Calcula el importe total a pagar por una compra.
     *
     * @param precioBase precio de una unidad, en euros
     * @param unidades número de unidades compradas
     * @param tipoCliente 1 = estudiante (10 %), 2 = jubilado (15 %), 3 = VIP (5 %); cualquier otro valor no tiene descuento
     * @param conEnvio {@code true} si se añade el recargo de envío urgente a domicilio
     * @return importe final en euros, con descuento, recargo de envío e IVA (21 %) aplicados
     */
    public static double calcularImporteFinal(final double precioBase, final int unidades,
            final int tipoCliente, final boolean conEnvio) {
        double importe = calcularSubtotal(precioBase, unidades);
        importe = aplicarDescuento(importe, tipoCliente);
        importe = aplicarRecargoEnvio(importe, conEnvio);
        return aplicarIva(importe);
    }

    private static double calcularSubtotal(final double precioBase, final int unidades) {
        return precioBase * unidades;
    }

    private static double aplicarDescuento(final double importe, final int tipoCliente) {
        if (tipoCliente == CLIENTE_ESTUDIANTE) {
            return importe - (importe * DESCUENTO_ESTUDIANTE);
        }
        if (tipoCliente == CLIENTE_JUBILADO) {
            return importe - (importe * DESCUENTO_JUBILADO);
        }
        if (tipoCliente == CLIENTE_VIP) {
            return importe - (importe * DESCUENTO_VIP);
        }
        return importe;
    }

    private static double aplicarRecargoEnvio(final double importe, final boolean conEnvio) {
        return conEnvio ? importe + RECARGO_ENVIO : importe;
    }

    private static double aplicarIva(final double importe) {
        return importe * FACTOR_IVA;
    }
}
