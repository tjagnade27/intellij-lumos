# LUMOS IntelliJ Plugin

IntelliJ IDEA and Rust Rover plugin for [LUMOS](https://lumos-lang.org) schema language.

**Write once in `.lumos`** → Generate type-safe Rust + TypeScript for Solana

---

## Features

✅ **File Type Recognition** - `.lumos` files recognized and highlighted
✅ **LSP Integration** - Full language server protocol support
✅ **Auto-Completion** - Smart suggestions for types and attributes
✅ **Real-Time Diagnostics** - Instant error detection and validation
✅ **Hover Documentation** - Inline type and attribute documentation
✅ **Multi-IDE Support** - Works with IntelliJ IDEA, Rust Rover, and CLion

---

## Installation

### Prerequisites

Install the LUMOS Language Server:

```bash
cargo install lumos-lsp
```

Verify installation:

```bash
lumos-lsp --version
# lumos-lsp 0.1.1
```

### Option 1: From JetBrains Marketplace (Coming Soon)

```
Settings → Plugins → Marketplace → Search "LUMOS" → Install → Restart IDE
```

### Option 2: Manual Installation

1. **Download** the latest `.zip` from [Releases](https://github.com/getlumos/intellij-lumos/releases)

2. **Install**:
   ```
   Settings → Plugins → ⚙️ → Install Plugin from Disk
   Select: intellij-lumos-X.X.X.zip
   Restart IDE
   ```

---

## Quick Start

1. **Open or create a `.lumos` file:**

```rust
#[solana]
#[account]
struct Player {
    wallet: PublicKey,
    score: u64,
    level: u16,
}
```

2. **Features activate automatically:**
   - ✅ Syntax highlighting
   - ✅ Auto-completion (`Pub` → `PublicKey`)
   - ✅ Error diagnostics (red squiggles)
   - ✅ Hover information

3. **Generate code:**
   ```bash
   lumos generate schema.lumos
   ```

---

## Supported IDEs

| IDE | Version | Status |
|-----|---------|--------|
| IntelliJ IDEA Community | 2024.1+ | ✅ Supported |
| IntelliJ IDEA Ultimate | 2024.1+ | ✅ Supported |
| Rust Rover | 2024.1+ | ✅ Supported |
| CLion | 2024.1+ | ✅ Supported |

---

## Configuration

### LSP Server Path

The plugin automatically detects `lumos-lsp` in:
1. `$CARGO_HOME/bin/lumos-lsp` (default Cargo install location)
2. System PATH

**Custom path (if needed):**
```
Settings → Languages & Frameworks → Language Servers
→ Configure server manually: /path/to/lumos-lsp
```

---

## Development

### Build from Source

```bash
# Clone repository
git clone https://github.com/getlumos/intellij-lumos.git
cd intellij-lumos

# Build plugin
./gradlew buildPlugin

# Output: build/distributions/intellij-lumos-0.1.0.zip
```

### Run in IDE Sandbox

```bash
./gradlew runIde
```

### Run Tests

```bash
./gradlew test
```

---

## Troubleshooting

### LSP Server Not Starting

**Symptom:** No auto-completion or diagnostics

**Fix:**
1. Verify LSP server is installed:
   ```bash
   which lumos-lsp
   ```

2. If missing, install:
   ```bash
   cargo install lumos-lsp
   ```

3. Check IDE logs:
   ```
   Help → Show Log in Finder → Search for "lumos"
   ```

### Plugin Not Recognized

**Symptom:** Can't find LUMOS in plugins list

**Fix:**
1. Ensure IDE version is **2024.1 or higher**
2. Install LSP4IJ dependency:
   ```
   Settings → Plugins → Marketplace → Search "LSP4IJ" → Install
   ```
3. Restart IDE

### File Type Not Recognized

**Symptom:** `.lumos` files open as plain text

**Fix:**
1. Right-click `.lumos` file
2. **Associate with File Type** → **LUMOS**
3. Restart IDE

---

## Architecture

```
Plugin Architecture:
┌─────────────────────────────────────┐
│ IntelliJ IDEA / Rust Rover          │
│                                     │
│  ┌──────────────────────────────┐  │
│  │ LUMOS Plugin                 │  │
│  │ - File Type Registration     │  │
│  │ - LSP Client (lsp4ij)        │  │
│  │ - Icon Provider              │  │
│  └──────────┬───────────────────┘  │
│             │ JSON-RPC (LSP)       │
│             v                       │
│  ┌──────────────────────────────┐  │
│  │ lumos-lsp                    │  │
│  │ (Language Server)            │  │
│  │ - Diagnostics                │  │
│  │ - Completion                 │  │
│  │ - Hover                      │  │
│  └──────────────────────────────┘  │
└─────────────────────────────────────┘
```

**Key Files:**
- `LumosFileType.kt` - File type registration
- `LumosLanguage.kt` - Language definition
- `LumosLspServerDescriptor.kt` - LSP client integration
- `plugin.xml` - Plugin manifest

---

## Contributing

Contributions welcome! See [CONTRIBUTING.md](https://github.com/getlumos/lumos/blob/main/CONTRIBUTING.md)

---

## Related Projects

- [**lumos**](https://github.com/getlumos/lumos) - Core compiler and CLI
- [**lumos-lsp**](https://crates.io/crates/lumos-lsp) - Language Server (required dependency)
- [**vscode-lumos**](https://github.com/getlumos/vscode-lumos) - VS Code extension
- [**docs-lumos**](https://github.com/getlumos/docs-lumos) - Official documentation

---

## License

Dual-licensed under:
- [MIT License](LICENSE-MIT)
- [Apache License 2.0](LICENSE-APACHE)

---

## Links

- **Website:** [lumos-lang.org](https://lumos-lang.org)
- **Documentation:** [docs.lumos-lang.org](https://docs.lumos-lang.org)
- **GitHub:** [github.com/getlumos](https://github.com/getlumos)
- **Issues:** [github.com/getlumos/intellij-lumos/issues](https://github.com/getlumos/intellij-lumos/issues)

---

**Made with ❤️ by the LUMOS team**
