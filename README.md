# Boilerplate Mod for Fabric

<p align="center">
  <img src="[https://github.com/WannaBeIan/Fabric-Mod-Template/blob/main/icon.png?raw=true](https://github.com/WannaBeIan/Fabric-Mod-Template/blob/main/src/main/resources/assets/boilerplatemod/icon.png)" alt="Mod Icon">
</p>

Welcome to my Boilerplate! This repository provides a modular and extensible template for developing Fabric mods. It is designed with client-side features in mind and includes:

## Note From UpFault

Hey there! Before you read any further, I wanted to add a few things. This is my personal template that I use for my own mods. It's by no means perfect, but it does what I need it to.

I recently created this template and decided to make it public for others to use, as I couldn’t find any good templates that included many of the features I have added. Feel free to fork the repo and send a pull request with improvements, or open an issue to request features—you can help keep this template up-to-date. The main reason I created this was to make developing mods for Hypixel a little easier. I’m relatively new to modding since I originally started as a plugin developer, and I’ve contributed to projects on this account as well as on my old GitHub account (for example, [Skyblocker](https://github.com/SkyblockerMod/Skyblocker)), because I love Skyblock and believe that creating client-side features for it offers endless customization opportunities.

Some key features I’d like to eventually add include multi-version support and a truly personalized configuration screen (instead of relying solely on an API like Cloth-Config). I do prefer YACL for its rich features, even though its documentation is limited. Feel free to reach out to me on Discord—my username is upfault.lol. Much love, and I hope this template helps new modders get started!

---

**TL;DR:**  
This is a personal mod template designed to simplify client-side mod development for Hypixel. It includes features like a custom configuration screen, key binding management, update checking, and various utility classes. While not perfect, it’s open-source, actively maintained, and open to contributions. Happy modding!


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
