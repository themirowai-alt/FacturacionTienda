public final class FacturacionTienda {

    private static final int CLIENTE_ESTUDIANTE = 1;
    private static final int CLIENTE_JUBILADO = 2;

    private static final double DESCUENTO_ESTUDIANTE = 0.10;
    private static final double DESCUENTO_JUBILADO = 0.15;
    private static final double RECARGO_ENVIO = 4.95;
    private static final double FACTOR_IVA = 1.21;

    private FacturacionTienda() {
        // Clase de utilidad: no se instancia.
    }

    public static void main(final String[] args) {
        // Prueba de funcionamiento:
        // precioBase = 100.0, unidades = 2, tipoCliente = 1 (estudiante), conEnvio = true
        final double resultado = calcularImporteFinal(100.0, 2, CLIENTE_ESTUDIANTE, true);
        System.out.println("Importe total a pagar: " + resultado);
    }

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
        return importe;
    }

    private static double aplicarRecargoEnvio(final double importe, final boolean conEnvio) {
        return conEnvio ? importe + RECARGO_ENVIO : importe;
    }

    private static double aplicarIva(final double importe) {
        return importe * FACTOR_IVA;
    }
}
