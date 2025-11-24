# GitHub Actions Workflows

This directory contains CI/CD workflows for the IntelliJ LUMOS plugin.

## Workflows

### 1. Build and Test (`build.yml`)

**Triggers:**
- Push to `main` or `dev` branches
- Pull requests to `main` or `dev`

**Actions:**
- Builds the plugin
- Runs all tests
- Verifies plugin structure
- Uploads build artifacts (7-day retention)

**Purpose:** Ensures code quality on every commit and PR.

---

### 2. Publish to Marketplace (`publish.yml`)

**Triggers:**
- Git tags matching `v*.*.*` (e.g., `v0.1.0`, `v0.2.1`)

**Actions:**
- Builds and tests the plugin
- Publishes to JetBrains Marketplace (automated)
- Creates GitHub Release with:
  - Plugin ZIP file attached
  - Auto-generated release notes
  - Installation instructions

**Purpose:** Automated releases to marketplace.

---

## Setup Required

### For Automated Publishing

Before triggering a release, you need to set up the marketplace token:

1. **Get JetBrains Marketplace Token:**
   - Go to https://plugins.jetbrains.com
   - Log in with your JetBrains account
   - Navigate to: Profile → **My Tokens**
   - Click **Generate New Token**
   - Give it a name: `GitHub Actions - intellij-lumos`
   - Copy the token (you'll only see it once!)

2. **Add Token to GitHub Secrets:**
   ```bash
   # Via GitHub UI:
   # Settings → Secrets and variables → Actions → New repository secret
   # Name: JETBRAINS_MARKETPLACE_TOKEN
   # Value: <paste your token>
   
   # Or via GitHub CLI:
   gh secret set JETBRAINS_MARKETPLACE_TOKEN
   # Paste token when prompted
   ```

3. **Verify Setup:**
   - Token must have "Publish Plugin" permission
   - Secret name must exactly match: `JETBRAINS_MARKETPLACE_TOKEN`

---

## How to Release

### Manual First Release (v0.1.0)

For the initial release, upload manually to establish the plugin:

1. Go to https://plugins.jetbrains.com/plugin/add
2. Upload `build/distributions/intellij-lumos-0.1.0.zip`
3. Fill in all required fields
4. Wait for JetBrains approval (~1-3 days)

### Automated Future Releases

Once the plugin is approved and token is set up:

```bash
# 1. Update version in build.gradle.kts
# 2. Commit changes
git add build.gradle.kts
git commit -m "chore: Bump version to 0.2.0"

# 3. Create and push tag
git tag v0.2.0
git push origin v0.2.0

# 4. GitHub Actions will automatically:
#    - Build the plugin
#    - Run tests
#    - Publish to marketplace
#    - Create GitHub release
```

**That's it!** Check:
- GitHub Actions: https://github.com/getlumos/intellij-lumos/actions
- Marketplace: https://plugins.jetbrains.com/plugin/XXXXX-lumos

---

## Troubleshooting

### Build Fails

```bash
# Run locally to debug:
./gradlew clean buildPlugin test verifyPlugin
```

### Publish Fails

1. Check token is set: `gh secret list`
2. Verify token has "Publish Plugin" permission
3. Check logs: GitHub Actions → Publish workflow → View details
4. Common issues:
   - Token expired (regenerate in marketplace)
   - Plugin not yet approved (do manual first release)
   - Version already published (update version number)

### Release Notes Missing

- Release notes are auto-generated from commits since last tag
- Write good commit messages for better release notes
- You can manually edit release notes after creation

---

## Status Badges

Add to README.md:

```markdown
[![Build Status](https://github.com/getlumos/intellij-lumos/workflows/Build%20and%20Test/badge.svg)](https://github.com/getlumos/intellij-lumos/actions)
[![JetBrains Plugin](https://img.shields.io/jetbrains/plugin/v/XXXXX-lumos.svg)](https://plugins.jetbrains.com/plugin/XXXXX-lumos)
```

(Replace XXXXX with actual plugin ID after marketplace approval)
