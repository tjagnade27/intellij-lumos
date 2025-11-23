# CLAUDE.md - IntelliJ IDEA Plugin

> **Ecosystem Context:** See [getlumos/lumos/CLAUDE.md](https://github.com/getlumos/lumos/blob/main/CLAUDE.md) for LUMOS ecosystem overview, cross-repo standards, and shared guidelines.

---

## Architecture

- `src/main/kotlin/com/lumos/LumosLanguage.kt` - Language definition
- `src/main/kotlin/com/lumos/LumosFileType.kt` - File type registration
- `src/main/kotlin/com/lumos/LumosLspServerDescriptor.kt` - LSP client integration
- `src/main/kotlin/com/lumos/LumosParserDefinition.kt` - Minimal parser (LSP handles actual parsing)
- `src/main/resources/META-INF/plugin.xml` - Plugin manifest
- `build.gradle.kts` - Gradle build configuration

---

## Development

```bash
# Build plugin
./gradlew buildPlugin

# Run plugin in IDE sandbox
./gradlew runIde

# Run tests
./gradlew test

# Package for distribution
./gradlew buildPlugin
# Output: build/distributions/intellij-lumos-0.1.0.zip
```

---

## Installation & Testing

### Option 1: Install from Marketplace
```
Settings → Plugins → Marketplace → Search "LUMOS" → Install
```

### Option 2: Install from Disk
```
1. Build: ./gradlew buildPlugin
2. Settings → Plugins → ⚙️ → Install Plugin from Disk
3. Select: build/distributions/intellij-lumos-0.1.0.zip
4. Restart IDE
```

### Prerequisites
- Install LUMOS Language Server: `cargo install lumos-lsp`
- LSP server must be in PATH or `~/.cargo/bin/`

---

## Testing Checklist

- [ ] Plugin recognizes `.lumos` files
- [ ] Syntax highlighting active for `.lumos` files
- [ ] LSP server starts automatically when opening `.lumos` file
- [ ] Auto-completion works (type `Pub` → suggests `PublicKey`)
- [ ] Diagnostics show errors (invalid syntax → red squiggles)
- [ ] Hover information displays (hover over type → shows documentation)

---

## Publishing to JetBrains Marketplace

```bash
# Set environment variable
export PUBLISH_TOKEN=<your-jetbrains-marketplace-token>

# Publish
./gradlew publishPlugin
```

**Marketplace URL:** https://plugins.jetbrains.com/plugin/XXXXX-lumos

---

## Dependencies

### LSP Client
- **Plugin ID:** `com.redhat.devtools.lsp4ij`
- **Version:** 0.0.2+
- **Purpose:** Provides LSP client infrastructure for IntelliJ

### LUMOS LSP Server
- **Package:** `lumos-lsp` (Rust crate)
- **Install:** `cargo install lumos-lsp`
- **Version:** 0.1.1+

---

## Target IDEs

✅ **Supported:**
- IntelliJ IDEA Community (2024.1+)
- IntelliJ IDEA Ultimate (2024.1+)
- Rust Rover (2024.1+)
- CLion (2024.1+)

---

## Gotchas

- **LSP server must be installed separately:** Plugin doesn't bundle lumos-lsp
- **Path detection:** Plugin checks `$CARGO_HOME/bin/lumos-lsp` first, then PATH
- **Plugin reload:** After installing, restart IDE for changes to take effect
- **LSP logs:** Check `Help → Show Log in Finder` for LSP communication logs
- **Version compatibility:** `sinceBuild=241` (2024.1+), `untilBuild=243.*` (2024.3.x)

---

## Icon

Icon file: `src/main/resources/icons/lumos.svg`
- 16x16 SVG with Solana gradient (green→purple)
- Used for file type recognition

---

## Build Properties

| Property | Value |
|----------|-------|
| Plugin ID | `com.lumos.intellij` |
| Version | `0.1.0` |
| IntelliJ Platform | Community Edition 2024.1 |
| Java Target | 17 |
| Kotlin Version | 1.9.21 |

---

## Troubleshooting

### LSP server not starting

**Symptom:** No auto-completion, no diagnostics
**Fix:**
1. Check lumos-lsp is installed: `which lumos-lsp`
2. Install if missing: `cargo install lumos-lsp`
3. Verify version: `lumos-lsp --version` (should be 0.1.1+)
4. Check IDE logs: `Help → Show Log in Finder`

### Plugin not recognized after installation

**Symptom:** Can't find LUMOS in plugins list
**Fix:**
1. Ensure IntelliJ IDEA version is 2024.1 or higher
2. Check LSP4IJ plugin is installed: `Settings → Plugins → Installed`
3. Restart IDE completely

### File type not recognized

**Symptom:** `.lumos` files open as plain text
**Fix:**
1. Right-click `.lumos` file → Associate with File Type → LUMOS
2. Restart IDE

---

**Status:** v0.1.0 development
**Last Updated:** 2025-11-23
