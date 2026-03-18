# HelloToast - Laboratoire Android Studio

> **Un projet pédagogique simple pour apprendre les bases d'Android : Buttons, TextViews, Toast et gestion des événements.**

## 📱 Objectifs du Laboratoire

- ✅ Créer une application Android simple
- ✅ Concevoir une interface avec XML
- ✅ Implémenter des écouteurs d'événements (OnClickListener)
- ✅ Afficher des messages Toast
- ✅ Gérer un compteur dynamique
- ✅ Comprendre le cycle de vie d'une Activity
- ✅ Lier les composants XML au code Java

---

## 🎯 Fonctionnalités

| Fonctionnalité | Description |
|---|---|
| **Toast** | Affiche un message temporaire "Bonjour !" |
| **Compteur** | Affiche et incrémente un compteur à chaque clic |
| **Interface simple** | LinearLayout avec 2 boutons et 1 TextView |
| **Responsive** | S'adapte à différentes tailles d'écran |

---

## 📋 Prérequis

- **Android Studio** 4.0+ (dernière version recommandée)
- **SDK Android 24+** (Android 7.0 minimum)
- **JDK 11+**
- **5 minutes** pour compléter le lab

### Installation rapide d'Android Studio

```bash
# Ubuntu/Debian
sudo apt-get install android-studio

# macOS (Homebrew)
brew install android-studio

# Windows
# Téléchargez depuis: https://developer.android.com/studio
```

---

## 🚀 Démarrage Rapide

### Étape 1 : Créer le projet

```bash
# Option 1 : Via Android Studio GUI
File → New → New Project → Empty Activity
Project Name: HelloToast
Language: Java
Minimum API Level: 24

# Option 2 : Via ligne de commande
# (Les commandes CLI Android dépendent de votre setup)
```

### Étape 2 : Copier les fichiers

1. **Remplacez** `res/layout/activity_main.xml`
2. **Remplacez** `app/java/com/example/hellotoast/MainActivity.java`
3. **Recompiler** (Build → Rebuild Project)

### Étape 3 : Lancer l'application

```bash
# Option 1 : Avec un émulateur Android
Android Studio → Run → Run 'app'

# Option 2 : Avec un appareil physique
adb devices              # Vérifier la connexion
adb install app.apk     # Installer l'app
```

---

## 📁 Structure du Projet

```
HelloToast/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/example/hellotoast/
│   │   │   │       └── MainActivity.java        ⭐ Code principal
│   │   │   └── res/
│   │   │       ├── layout/
│   │   │       │   └── activity_main.xml        ⭐ Interface XML
│   │   │       ├── values/
│   │   │       │   └── strings.xml
│   │   │       └── drawable/
│   │   └── test/
│   └── build.gradle
├── build.gradle (projet)
├── settings.gradle
└── README.md
```

---

## 💻 Code Source Complet

### 1️⃣ Layout XML - `res/layout/activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="16dp"
    android:background="#F5F5F5">

    <!-- Titre -->
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="HelloToast Lab"
        android:textSize="28sp"
        android:textStyle="bold"
        android:textColor="#333333"
        android:layout_marginBottom="32dp" />

    <!-- Compteur -->
    <TextView
        android:id="@+id/text_count"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="0"
        android:textSize="72sp"
        android:textStyle="bold"
        android:textColor="#2196F3"
        android:layout_marginBottom="24dp" />

    <!-- Étiquette compteur -->
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Clics"
        android:textSize="18sp"
        android:textColor="#666666"
        android:layout_marginBottom="40dp" />

    <!-- Bouton Toast -->
    <Button
        android:id="@+id/button_toast"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:text="Afficher un Message"
        android:textSize="16sp"
        android:textColor="#FFFFFF"
        android:background="#FF9800"
        android:backgroundTint="#FF9800"
        android:layout_marginBottom="12dp"
        android:padding="12dp" />

    <!-- Bouton Compteur -->
    <Button
        android:id="@+id/button_count"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:text="Incrémenter le Compteur"
        android:textSize="16sp"
        android:textColor="#FFFFFF"
        android:background="#2196F3"
        android:backgroundTint="#2196F3"
        android:padding="12dp" />

</LinearLayout>
```

### 2️⃣ Code Java - `app/java/com/example/hellotoast/MainActivity.java`

```java
package com.example.hellotoast;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // ========== VARIABLES ==========
    
    // Compteur global
    private int count = 0;
    
    // Référence vers le TextView du compteur
    private TextView textCount;

    // ========== MÉTHODE PRINCIPALE ==========
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Lie le fichier XML activity_main.xml à cette Activity
        setContentView(R.layout.activity_main);

        // ========== RÉCUPÉRATION DES COMPOSANTS ==========
        
        // Récupère le TextView (affiche le compteur)
        textCount = findViewById(R.id.text_count);
        
        // Récupère les deux boutons
        Button buttonToast = findViewById(R.id.button_toast);
        Button buttonCount = findViewById(R.id.button_count);

        // ========== GESTION DES CLICS ==========
        
        // Écouteur pour le bouton "Afficher un message"
        buttonToast.setOnClickListener(v -> {
            // Affiche un Toast avec le message "Bonjour !"
            Toast.makeText(
                MainActivity.this,           // Contexte
                "Bonjour !",                 // Message
                Toast.LENGTH_SHORT           // Durée d'affichage
            ).show();
        });

        // Écouteur pour le bouton "Incrémenter le compteur"
        buttonCount.setOnClickListener(v -> {
            // Incrémente le compteur
            count++;
            
            // Met à jour l'affichage du TextView
            textCount.setText(String.valueOf(count));
            
            // (Optionnel) Affiche un petit Toast avec la nouvelle valeur
            Toast.makeText(
                MainActivity.this,
                "Compteur : " + count,
                Toast.LENGTH_SHORT
            ).show();
        });
    }

    // ========== CYCLE DE VIE (OPTIONNEL) ==========
    
    @Override
    protected void onStart() {
        super.onStart();
        // Appelé quand l'Activity devient visible
        System.out.println("onStart() appelé");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Appelé quand l'Activity devient interactive
        System.out.println("onResume() appelé");
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Appelé quand l'Activity perd le focus
        System.out.println("onPause() appelé");
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Appelé quand l'Activity n'est plus visible
        System.out.println("onStop() appelé");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Appelé avant la destruction de l'Activity
        System.out.println("onDestroy() appelé");
    }
}
```

---

## 🔍 Explications Détaillées

### Qu'est-ce qu'une Activity ?

Une **Activity** est un écran dans une application Android. Elle représente l'interface utilisateur et gère les interactions.

```java
public class MainActivity extends AppCompatActivity { ... }
```

### La méthode `onCreate()`

Appelée une seule fois au démarrage de l'Activity. C'est ici qu'on initialise l'interface :

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);  // Charge le layout XML
}
```

### `findViewById()` - Récupérer un composant

Permet de récupérer un élément du layout XML en utilisant son `id` :

```java
Button buttonToast = findViewById(R.id.button_toast);
TextView textCount = findViewById(R.id.text_count);
```

### `setOnClickListener()` - Écouter un clic

Définit une action quand l'utilisateur clique sur un bouton :

```java
buttonToast.setOnClickListener(v -> {
    // Code exécuté au clic
    Toast.makeText(MainActivity.this, "Bonjour !", Toast.LENGTH_SHORT).show();
});
```

### `Toast.makeText()` - Afficher un message

Affiche un petit message temporaire à l'écran :

```java
Toast.makeText(
    context,              // Contexte (MainActivity.this)
    "Message",            // Texte à afficher
    Toast.LENGTH_SHORT    // Durée (SHORT = ~2 sec, LONG = ~3.5 sec)
).show();
```

### Mise à jour dynamique de TextView

```java
count++;  // Incrémente la variable
textCount.setText(String.valueOf(count));  // Affiche la nouvelle valeur
```

---

## 🎨 Personnalisation

### Changer les couleurs

Dans `activity_main.xml` :

```xml
<!-- Couleur du compteur (bleu par défaut) -->
android:textColor="#2196F3"

<!-- Couleur du bouton Toast (orange) -->
android:background="#FF9800"

<!-- Couleur du bouton Compteur (bleu) -->
android:background="#2196F3"
```

### Changer les textes

```xml
android:text="Mon texte personnalisé"
```

### Changer la taille des polices

```xml
android:textSize="24sp"  <!-- sp = Scale-independent Pixels -->
```

---

## 📲 Test sur Émulateur

### Créer un AVD (Android Virtual Device)

```bash
# Dans Android Studio:
Tools → AVD Manager → Create Virtual Device

# Sélectionner:
- Device: Pixel 5
- OS: Android 13 (API 33)
- RAM: 2GB minimum
```

### Lancer l'émulateur

```bash
# Option 1 : Depuis Android Studio
Run → Run 'app'

# Option 2 : Depuis le terminal
emulator -avd nom_avd &
adb install app-debug.apk
```

---

## 🐛 Dépannage Courant

### Problème: "Cannot resolve symbol 'R'"

**Solution:**
```bash
Build → Clean Project
Build → Rebuild Project
File → Sync Now
```

### Problème: "Activity not found"

**Vérifiez** `AndroidManifest.xml` :

```xml
<activity android:name=".MainActivity"
    android:exported="true">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>
```

### Problème: "Emulator is not starting"

**Solutions:**
1. Vérifiez la virtualisation CPU (BIOS)
2. Augmentez la RAM allouée (3-4 GB)
3. Utilisez API 29 au lieu d'API 33

---

## 📚 Ressources Recommandées

| Ressource | Lien |
|-----------|------|
| **Documentation Android** | https://developer.android.com/docs |
| **Android Studio Guide** | https://developer.android.com/studio |
| **Toast Documentation** | https://developer.android.com/guide/topics/ui/notifiers/toasts |
| **Layout XML** | https://developer.android.com/guide/topics/ui/declaring-layout |
| **Event Handling** | https://developer.android.com/guide/topics/ui/ui-events |

---

## 🎓 Concepts Appris

- ✅ **Activity** : Écran d'une application
- ✅ **Layout XML** : Conception d'interface
- ✅ **findViewById()** : Récupération de composants
- ✅ **setOnClickListener()** : Gestion des événements
- ✅ **Toast** : Messages temporaires
- ✅ **TextView** : Affichage de texte
- ✅ **Button** : Boutons interactifs
- ✅ **LinearLayout** : Organisation verticale
- ✅ **Cycle de vie** : onCreate(), onStart(), onResume(), etc.
- ✅ **Data binding** : Liaison XML ↔ Java

---

## 📈 Évolutions Possibles

Voici comment améliorer ce projet :

1. **Ajouter un bouton RESET**
   ```java
   Button buttonReset = findViewById(R.id.button_reset);
   buttonReset.setOnClickListener(v -> {
       count = 0;
       textCount.setText("0");
   });
   ```

2. **Sauvegarder le compteur** (SharedPreferences)
   ```java
   SharedPreferences prefs = getSharedPreferences("data", MODE_PRIVATE);
   count = prefs.getInt("count", 0);  // Récupérer
   prefs.edit().putInt("count", count).apply();  // Sauvegarder
   ```

3. **Ajouter des animations**
   ```java
   textCount.animate().scaleX(1.2f).scaleY(1.2f).setDuration(300).start();
   ```

4. **Personnaliser le design** (Material Design)
   ```xml
   android:background="?attr/colorPrimary"
   android:elevation="4dp"
   ```

---

## 📝 Exercices Supplémentaires

### Exercice 1 : Décrémenteur
Ajoutez un bouton pour **diminuer** le compteur.

### Exercice 2 : Son
Ajoutez un son quand le compteur augmente.

### Exercice 3 : Couleur dynamique
Changez la couleur du compteur selon sa valeur.

### Exercice 4 : AlertDialog
Remplacez le Toast par une AlertDialog.

---

## 👨‍💻 Auteur

**Lab Android pédagogique** - [Votre Université/École]

---

## 📄 Licence

Ce projet est mis à disposition à titre pédagogique sous la licence **MIT**.

```
MIT License

Copyright (c) 2024 HelloToast Lab

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
...
```

---

## 🤝 Contribution

Les contributions sont bienvenues ! N'hésitez pas à :
- Signaler des bugs
- Proposer des améliorations
- Ajouter des fonctionnalités
- Améliorer la documentation

```bash
# Fork le projet
# Créez une branche (git checkout -b feature/AmazingFeature)
# Committez (git commit -m 'Add AmazingFeature')
# Push (git push origin feature/AmazingFeature)
# Ouvrez une Pull Request
```

---

## ⭐ N'oubliez pas de donner une étoile ⭐

Si ce lab vous a été utile, n'hésitez pas à donner une ⭐ star au repository !

---

## 📞 Support

Si vous avez des questions :
1. Consultez la **section Dépannage**
2. Vérifiez les **ressources officielles**
3. Ouvrez une **GitHub Issue**

---

**Bon développement Android ! 🚀**
