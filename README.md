# Boilerplate Mod for Fabric

Welcome to my Boilerplate! This repository provides a modular and extensible template for developing Fabric mods. It is designed with client-side features in mind and includes:

## Features

- **Configuration System:**
  Uses AutoConfig and Cloth Config to build a customizable configuration screen. Options are organized into categories, and texts are fully translatable.

- **Key Binding Management:**
  A centralized `KeyBindManager` registers key bindings and handles client tick events, making it easy to assign actions (like opening the config screen).

- **Update Checker:**
  Checks GitHub releases to notify users when a new version is available. Customize it by updating the repository owner, repository name, and current version in `UpdateChecker.java`.

- **Utility Classes:**
  Includes several helpful utilities:
  - **MathUtils:** Clamping and interpolation functions.
  - **StringUtils:** Common string manipulations.
  - **ColorUtils:** Includes methods for standard RGB conversion plus two chroma effects:
    - *Smooth Chroma:* Applies a single, smoothly shifting rainbow color to the entire string.
    - *Chroma Per Letter:* Applies an individual rainbow effect to each character.
  - **TimeUtils:** Simple time formatting from milliseconds.

## Setup Instructions

1. **Fork or Clone the Repository:**
   Fork this repository on GitHub or clone it locally.

2. **Update Mod Identifiers:**
   Replace all references of `boilerplatemod` with your own mod ID. This includes:
   - Package names (e.g., change `com.upfault.boilerplatemod` to your package).
   - `fabric.mod.json` entries (the `"id"` and asset paths).
   - The configuration name in `ModConfig.java`.

3. **Configure Dependencies:**
   Ensure your `build.gradle` and `gradle.properties` files list the correct versions for:
   - Fabric Loader & Fabric API
   - Cloth Config
   - Any other required libraries
   (See the provided example files for guidance.)

4. **Build and Run:**
   Use Gradle to build and run your mod:
   ```bash
   ./gradlew runClient
   
## License

This project is licensed under the [MIT License](https://github.com/WannaBeIan/Fabric-Mod-Template/blob/main/LICENSE).
