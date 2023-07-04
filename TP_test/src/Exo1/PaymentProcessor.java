package Exo1;

public class PaymentProcessor {
    private CarteCreditManager carteCreditManager;
    private PaymentGateway paymentGateway;

    public PaymentProcessor(CarteCreditManager carteCreditManager, PaymentGateway paymentGateway) {
        this.carteCreditManager = carteCreditManager;
        this.paymentGateway = paymentGateway;
    }

    public String processPayment(double montant, String numCart, String cvv) {
        if (!carteCreditManager.verifyCard(numCart, cvv)) {
            throw new IllegalArgumentException("Les informations de la carte sont invalides");
        }

        String transactionId = paymentGateway.makePayment(montant);

        return transactionId;
    }
}
