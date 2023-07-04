package Exo1;
public class CarteCreditManager {

    // V�rifie si les informations de la carte de cr�dit sont valides.
    public boolean verifyCard(String numCarte, String cvv) {
        if (numCarte == null || cvv == null) {
            return false;
        }

        // Le num�ro de carte doit avoir 16 chiffres.
        if (numCarte.length() != 16) {
            return false;
        }

        // Le CVV doit avoir 3 chiffres.
        if (cvv.length() != 3) {
            return false;
        }

        // V�rifie si tous les caract�res de numCarte et cvv sont des chiffres.
        return numCarte.chars().allMatch(Character::isDigit) && cvv.chars().allMatch(Character::isDigit);
    }
}