This project inherit from original mod and using TemplateDevEnv as mod development environment standard.

## Addendum
- Backpack don't have handler for shift click item movement (only happen with increase stack size, insert new stack will not trigger this). This lead to backpack reverse its inventory if leave and rejoin early, before markDirty kicked in. Similar issue to LP.
- Code base is horrendous ~~not gonna lies~~, it is good to handle alot of case... But try digging the code base always make me feel uncomfortable. Maybe it just me schizo, but if you want to try fix any issue from this mods, better just use this as base code and rewrite from scratch instead.

## TemplateDevEnv

Template workspace for modding Minecraft 1.12.2. Licensed under MIT, it is made for public use.

This template currently utilizies **Gradle 8.3** + **[RetroFuturaGradle](https://github.com/GTNewHorizons/RetroFuturaGradle) 1.3.27** + **Forge 14.23.5.2860**.

With **coremod and mixin support** that is easy to configure.

### Instructions:

1. Click `use this template` at the top.
2. Clone the repository you have created with this template.
3. In the local repository, run the command `gradlew setupDecompWorkspace`
4. Open the project folder in IDEA.
5. Right-click in IDEA `build.gradle` of your project, and select `Link Gradle Project`, after completion, hit `Refresh All` in the gradle tab on the right.
6. Run `gradlew runClient` and `gradlew runServer`, or use the auto-imported run configurations in IntelliJ like `1. Run Client`.

### Mixins:

- When writing Mixins on IntelliJ, it is advisable to use latest [MinecraftDev Fork for RetroFuturaGradle](https://github.com/eigenraven/MinecraftDev/releases).
