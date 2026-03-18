package com.example.hellotoast;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/**
 * HelloToast - Application de Démonstration Android
 * 
 * Cette Activity affiche:
 * - Un compteur dynamique (TextView)
 * - Un bouton pour afficher un Toast
 * - Un bouton pour incrémenter le compteur
 * 
 * Concepts:
 * - Activity: Écran de l'application
 * - onCreate(): Méthode appelée au démarrage
 * - findViewById(): Récupère un composant XML
 * - setOnClickListener(): Écoute les clics
 * - Toast: Message temporaire
 */
public class MainActivity extends AppCompatActivity {

    // ========================================
    // VARIABLES GLOBALES
    // ========================================
    
    /**
     * Compteur de clics
     * Stocke le nombre de fois où le bouton "Incrémenter" a été cliqué
     */
    private int count = 0;
    
    /**
     * Référence vers le TextView affichant le compteur
     * Déclaré globalement pour y accéder depuis les écouteurs d'événements
     */
    private TextView textCount;

    // ========================================
    // CYCLE DE VIE - onCreate()
    // ========================================
    
    /**
     * onCreate() est appelée une seule fois au démarrage de l'Activity.
     * C'est ici qu'on initialise l'interface et les écouteurs.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Lie le layout XML activity_main.xml à cette Activity
        // Tous les composants du XML deviennent accessibles via findViewById()
        setContentView(R.layout.activity_main);

        // ========================================
        // RÉCUPÉRATION DES COMPOSANTS XML
        // ========================================
        
        // Récupère le TextView affichant le compteur
        // Le id @+id/text_count doit exister dans activity_main.xml
        textCount = findViewById(R.id.text_count);
        
        // Récupère le bouton "Afficher un message"
        Button buttonToast = findViewById(R.id.button_toast);
        
        // Récupère le bouton "Incrémenter le compteur"
        Button buttonCount = findViewById(R.id.button_count);

        // ========================================
        // ÉCOUTEURS D'ÉVÉNEMENTS (EVENT LISTENERS)
        // ========================================

        // ----- BOUTON TOAST -----
        
        /**
         * Écouteur pour le bouton "Afficher un message"
         * Utilise une lambda (syntaxe moderne) pour simplifier le code
         * 
         * Alternative (syntaxe classique):
         * buttonToast.setOnClickListener(new View.OnClickListener() {
         *     @Override
         *     public void onClick(View v) {
         *         // Code ici
         *     }
         * });
         */
        buttonToast.setOnClickListener(v -> {
            // Crée et affiche un Toast
            Toast.makeText(
                MainActivity.this,      // Contexte (l'Activity courante)
                "Bonjour !",            // Message à afficher
                Toast.LENGTH_SHORT      // Durée (~2 secondes)
            ).show();                   // Affiche le Toast
        });

        // ----- BOUTON COMPTEUR -----
        
        /**
         * Écouteur pour le bouton "Incrémenter le compteur"
         */
        buttonCount.setOnClickListener(v -> {
            // Incrémente le compteur de 1
            count++;
            
            // Met à jour l'affichage du TextView avec la nouvelle valeur
            // String.valueOf() convertit un int en String
            textCount.setText(String.valueOf(count));
            
            // (OPTIONNEL) Affiche un Toast avec la nouvelle valeur
            Toast.makeText(
                MainActivity.this,
                "Compteur : " + count,
                Toast.LENGTH_SHORT
            ).show();
        });
    }

    // ========================================
    // CYCLE DE VIE - AUTRES MÉTHODES (OPTIONNEL)
    // ========================================
    
    /**
     * onStart() est appelée quand l'Activity devient visible.
     * Utile pour reprendre les ressources ou les mises à jour.
     */
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart() - Activity visible");
    }

    /**
     * onResume() est appelée quand l'Activity devient interactive
     * (au premier plan et peut recevoir les interactions utilisateur).
     */
    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume() - Activity interactive");
    }

    /**
     * onPause() est appelée quand l'Activity perd le focus.
     * L'utilisateur navigue vers une autre Activity, reçoit un appel, etc.
     * Utile pour sauvegarder les données.
     */
    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause() - Activity perd le focus");
    }

    /**
     * onStop() est appelée quand l'Activity n'est plus visible.
     * Une autre Activity ou application est au premier plan.
     */
    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop() - Activity invisible");
    }

    /**
     * onDestroy() est appelée avant la destruction complète de l'Activity.
     * Utile pour libérer les ressources (threads, listeners, etc.).
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy() - Activity détruite");
    }

    // ========================================
    // MÉTHODES PERSONNALISÉES (OPTIONNEL)
    // ========================================
    
    /**
     * Méthode pour augmenter le compteur
     * (Alternative à l'écouteur inline)
     */
    private void incrementCounter() {
        count++;
        updateCounterDisplay();
    }
    
    /**
     * Méthode pour réinitialiser le compteur
     */
    private void resetCounter() {
        count = 0;
        updateCounterDisplay();
    }
    
    /**
     * Méthode pour mettre à jour l'affichage du compteur
     * Utile si on a plusieurs endroits où le compteur change
     */
    private void updateCounterDisplay() {
        textCount.setText(String.valueOf(count));
    }
    
    /**
     * Méthode pour afficher un Toast personnalisé
     */
    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
