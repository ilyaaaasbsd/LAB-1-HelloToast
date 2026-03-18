# 🚀 Guide d'Installation - HelloToast

Guide étape par étape pour créer et exécuter l'application HelloToast.

## ⏱️ Durée Estimée: 30 minutes

## 📋 Table des Matières

- [Vérification des Prérequis](#vérification-des-prérequis)
- [Installation d'Android Studio](#installation-dandroid-studio)
- [Création du Projet](#création-du-projet)
- [Copie des Fichiers](#copie-des-fichiers)
- [Exécution sur Émulateur](#exécution-sur-émulateur)
- [Exécution sur Téléphone](#exécution-sur-téléphone)
- [Dépannage](#dépannage)

---

## ✅ Vérification des Prérequis

### Système d'exploitation

```bash
# Windows 10+
ver

# macOS 10.14+
sw_vers

# Linux (Ubuntu/Debian)
uname -r
```

### RAM disponible

```bash
# Windows
wmic OS get TotalVisibleMemorySize,FreePhysicalMemory

# macOS
vm_stat | grep Pages

# Linux
free -h
```

**Minimum requis: 8 GB RAM**

### Processeur 64-bit

```bash
# Windows
wmic os get osarchitecture

# macOS
uname -m

# Linux
uname -m
```

**Minimum requis: x86_64**

---

## 📲 Installation d'Android Studio

### Windows

1. Télécharger depuis: https://developer.android.com/studio
2. Exécuter l'installateur `.exe`
3. Suivre les instructions
4. Accepter les licences
5. Attendre la fin de l'installation (~10 minutes)

### macOS

```bash
# Avec Homebrew (recommandé)
brew install android-studio

# Ou télécharger manuellement depuis:
# https://developer.android.com/studio
```

### Linux (Ubuntu/Debian)

```bash
# Télécharger
wget https://developer.android.com/studio/install

# Extraire
unzip android-studio-*-linux.tar.gz

# Lancer
./android-studio/bin/studio.sh
```

### Vérification

Lancez Android Studio et vérifiez:
1. **File** → **Settings** → **System Settings** → **Android SDK**
2. Cochez **API 24+** dans "SDK Platforms"

---

## 🎯 Création du Projet

### Étape 1: Créer un nouveau projet

```
1. Android Studio → File → New → New Project
2. Sélectionner: "Empty Activity"
3. Cliquer: Next
```

### Étape 2: Configurer le projet

| Champ | Valeur |
|-------|--------|
| **Name** | `HelloToast` |
| **Package name** | `com.example.hellotoast` |
| **Save location** | `C:\Users\YourName\AndroidProjects` |
| **Language** | `Java` |
| **Minimum API** | `API 24: Android 7.0` |

```
3. Cliquer: Next
4. Cliquer: Finish
5. Attendre la synchronisation Gradle (2-3 minutes)
```

### Résultat Attendu

```
Project created successfully!
├── app/
│   └── src/
│       └── main/
│           ├── java/com/example/hellotoast/MainActivity.java
│           └── res/layout/activity_main.xml
```

---

## 📄 Copie des Fichiers

### Fichier 1: activity_main.xml

1. Ouvrir: **app** → **res** → **layout** → **activity_main.xml**
2. Supprimer le contenu existant
3. Copier-coller le code d'activity_main.xml

### Fichier 2: MainActivity.java

1. Ouvrir: **app** → **src** → **main** → **java** → **com/example/hellotoast/MainActivity.java**
2. Supprimer le contenu existant
3. Copier-coller le code de MainActivity.java

### Vérification

```
Build → Clean Project
Build → Rebuild Project
File → Sync Now

Attend que les erreurs disparaissent.
```

**✓ Pas d'erreurs = Succès!**

---

## 🖥️ Exécution sur Émulateur

### Créer un AVD (Android Virtual Device)

```
1. Android Studio → Tools → Device Manager
2. Cliquer: "Create Virtual Device"
3. Sélectionner: "Pixel 5"
4. Cliquer: "Next"
5. Sélectionner: "API 33" (Android 13)
6. Cliquer: "Download" si nécessaire
7. Attendre le téléchargement (~1 GB)
8. Cliquer: "Next"
9. Cliquer: "Finish"
```

### Lancer l'émulateur

```
Device Manager:
1. Chercher votre AVD (ex: "Pixel_5_API_33")
2. Cliquer le bouton Play (▶)
3. Attendre le démarrage (1-2 minutes)
4. Vérifier la connexion ADB:
   - Ouvrir Terminal
   - Tapez: adb devices
   - Vous devez voir: emulator-5554 device
```

### Lancer l'application

```
Android Studio:
1. Run → Run 'app'
2. Sélectionner l'émulateur
3. Cliquer: OK
4. Attendre la compilation et l'installation (~1 minute)
5. L'app s'ouvre automatiquement
```

### Tests à Effectuer

```
1. Cliquer "Afficher un Message"
   ✓ Un Toast "Bonjour !" apparaît

2. Cliquer "Incrémenter le Compteur"
   ✓ Le compteur passe de 0 à 1
   ✓ Un Toast "Compteur: 1" apparaît

3. Cliquer "Incrémenter le Compteur" 5 fois
   ✓ Le compteur affiche: 1, 2, 3, 4, 5, 6
   ✓ Chaque Toast affiche la nouvelle valeur

4. Tourner l'écran (orientation)
   ✓ Le compteur se réinitialise (comportement normal)
```

---

## 📱 Exécution sur Téléphone Réel

### Préparation du téléphone

```
Paramètres:
1. Allez à: À propos du téléphone (About Phone)
2. Cherchez: Numéro de build (Build Number)
3. Appuyez 7 fois sur: Numéro de build
4. Un message: "Mode développeur activé"

Puis:
1. Allez à: Paramètres de développeur (Developer Options)
2. Cochez: Débogage USB (USB Debugging)
```

### Connexion au PC

```bash
# Connectez le téléphone via USB

# Vérifiez la connexion
adb devices

# Résultat attendu:
# List of attached devices
# FA8AL1A001 device

# Si vous voyez "unauthorized":
# 1. Vérifiez le câble USB
# 2. Appuyez "OK" sur le téléphone pour autoriser
# 3. Réexécutez: adb devices
```

### Lancer l'application

```
Android Studio:
1. Run → Run 'app'
2. Sélectionner votre téléphone (par exemple: FA8AL1A001)
3. Cliquer: OK
4. L'app s'installe sur votre téléphone
5. Elle s'ouvre automatiquement
```

---

## 🔧 Dépannage

### Problème: "Cannot resolve symbol 'R'"

```
Erreur:
Cannot resolve symbol 'R'

Solutions:
1. Build → Clean Project
2. Build → Rebuild Project
3. File → Sync Now
4. Fermer Android Studio et le relancer
```

### Problème: "Gradle sync failed"

```
Erreur:
Gradle sync failed

Solutions:
1. File → Sync Now
2. Attendre la fin de la synchronisation
3. Si cela persiste:
   - File → Invalidate Caches / Restart
   - Cliquer: Invalidate and Restart
```

### Problème: "Activity not found"

```
Erreur:
Activity not found

Cause:
MainActivity n'est pas enregistrée dans AndroidManifest.xml

Solution:
1. Ouvrir: app → src → main → AndroidManifest.xml
2. Vérifier que MainActivity est dedans:
   <activity android:name=".MainActivity" />
3. Si absent, ajouter:
   <activity android:name=".MainActivity"
       android:exported="true">
       <intent-filter>
           <action android:name="android.intent.action.MAIN" />
           <category android:name="android.intent.category.LAUNCHER" />
       </intent-filter>
   </activity>
```

### Problème: "Emulator not starting"

```
Erreur:
Émulateur ne démarre pas

Solutions:
1. Augmentez la RAM allouée:
   - Device Manager → Edit (crayon) → Advanced Settings
   - RAM: 4GB
   - VM Heap: 512MB

2. Utilisez API 29 au lieu de 33:
   - Crée un nouvel AVD avec API 29

3. Activez la virtualisation dans le BIOS:
   - Redémarrez votre PC
   - Entrez dans le BIOS (F2, F10, Delete... selon votre PC)
   - Cherchez: Virtualization Technology
   - Activez-le

4. Utilisez un téléphone réel à la place
```

### Problème: "App crashes au lancement"

```
Erreur:
L'app s'ouvre puis se ferme immédiatement

Solutions:
1. Ouvrez Logcat:
   View → Tool Windows → Logcat

2. Cherchez les erreurs rouges

3. Vérifiez que:
   - activity_main.xml existe
   - Tous les findViewById() ont un @+id correspondant
   - MainActivity.java n'a pas de fautes de frappe

4. Recompilez:
   Build → Rebuild Project
   Run → Run 'app'
```

### Problème: "App ne communique pas avec l'émulateur"

```
Sous Linux:

Solutions:
1. Arrêter l'émulateur
2. Redémarrer le serveur ADB:
   adb kill-server
   adb start-server

3. Relancer l'émulateur
4. Vérifier la connexion:
   adb devices
```

---

## ✅ Checklist Finale

- [ ] Android Studio installé et fonctionnel
- [ ] JDK 11+ installé
- [ ] Projet "HelloToast" créé
- [ ] activity_main.xml remplacé
- [ ] MainActivity.java remplacé
- [ ] Aucune erreur de compilation
- [ ] AVD créé et lancé
- [ ] Application installée sur l'émulateur
- [ ] Bouton Toast fonctionne
- [ ] Bouton Compteur fonctionne
- [ ] Compteur affiche les bonnes valeurs

---

## 🎓 Résumé des Commandes Utiles

```bash
# ADB - Android Debug Bridge
adb devices                    # Lister les appareils connectés
adb shell                      # Accès shell à l'appareil
adb logcat                     # Voir les logs en temps réel
adb install app.apk           # Installer une app
adb uninstall com.example.app # Désinstaller une app

# Gradle
./gradlew build               # Compiler le projet
./gradlew clean               # Nettoyer le projet
./gradlew test                # Lancer les tests

# Émulateur
emulator -list-avds           # Lister les AVD
emulator -avd MyAVD           # Lancer un AVD
```

---

## 📚 Ressources Supplémentaires

- **Android Studio Setup**: https://developer.android.com/studio/install
- **Android Emulator**: https://developer.android.com/studio/run/emulator
- **ADB Documentation**: https://developer.android.com/studio/command-line/adb
- **Android Developer Guide**: https://developer.android.com/guide

---

**Vous êtes prêt(e)! Commencez par la Création du Projet. 🚀**
