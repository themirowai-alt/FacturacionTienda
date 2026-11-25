public final class FacturacionTienda {

    private FacturacionTienda() {
        // Clase de utilidad: no se instancia.
    }

    public static void main(final String[] args) {
        // Prueba de funcionamiento:
        // precioBase = 100.0, unidades = 2, tipoCliente = 1 (estudiante), conEnvio = true
        final double resultado = calc(100.0, 2, 1, true);
        System.out.println("Importe total a pagar: " + resultado);
    }

    public static double calc(final double p, final int c, final int t, final boolean e) {
        double subtotal = p * c;

        // Descuento según tipo de cliente: 1 = Estudiante (10%), 2 = Jubilado (15%)
        if (t == 1) {
            subtotal = subtotal - (subtotal * 0.10);
        } else if (t == 2) {
            subtotal = subtotal - (subtotal * 0.15);
        }

        // Recargo por gastos de envío urgente a domicilio
        if (e) {
            subtotal = subtotal + 4.95;
        }

        // Impuesto general indirecto (IVA 21%)
        return subtotal * 1.21;
    }
}
