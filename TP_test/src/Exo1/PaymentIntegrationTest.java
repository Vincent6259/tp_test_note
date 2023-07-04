package Exo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentIntegrationTest {

    private PaymentProcessor paymentProcessor;
    private CarteCreditManager carteCreditManager;
    private PaymentGateway paymentGateway;

    @BeforeEach
    public void setup() {
        carteCreditManager = new CarteCreditManager();
        paymentGateway = new PaymentGateway();
        paymentProcessor = new PaymentProcessor(carteCreditManager, paymentGateway);
    }

    @Test
    public void testSuccessfulPayment() {
    	String numCart = "1234567890123456";
        String cvv = "123";
        double montant = 100.0;

        // Test si le paiement est effectué avec succès.
        assertDoesNotThrow(() -> paymentProcessor.processPayment(montant, numCart, cvv));
    }

    @Test
    public void testCardVerificationFails() {
    	String numCart = "123456789012345";  // Un chiffre manquant
        String cvv = "123";
        double montant = 100.0;

        // Test si la méthode processPayment lance une exception lors de l'utilisation d'une carte invalide.
        assertThrows(IllegalArgumentException.class, () -> paymentProcessor.processPayment(montant, numCart, cvv));
    }

    @Test
    public void testPaymentGatewayFailure() {
        // À remplir avec la logique de test pour une défaillance du PaymentGateway.
    }

    @Test
    public void testNegativeOrZeroPayment() {
    	String numCart = "1234567890123456";
        String cvv = "123";
        double montant = 0.0;

        // Test si la méthode makePayment lance une exception lors de l'utilisation d'un montant non valide.
        assertThrows(IllegalArgumentException.class, () -> paymentProcessor.processPayment(montant, numCart, cvv));
    }

}