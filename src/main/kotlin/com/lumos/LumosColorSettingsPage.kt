package com.lumos

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

/**
 * Color settings page for LUMOS language.
 * Allows users to customize syntax highlighting colors.
 */
class LumosColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon = LumosIcons.FILE

    override fun getHighlighter(): SyntaxHighlighter = LumosSyntaxHighlighter()

    override fun getDemoText(): String = """
// LUMOS Schema Language
#[solana]
#[account]
struct PlayerAccount {
    /// Player's wallet address
    wallet: PublicKey,

    /// Current score
    score: u64,

    /// Player level (1-100)
    level: u16,

    /// In-game items
    inventory: Vec<u8>,

    /// Last active timestamp
    last_active: i64,

    /// Optional email
    email: Option<String>,
}

#[solana]
enum GameState {
    /// Game is currently active
    Active,

    /// Game is paused
    Paused,

    /// Game ended with final score
    Finished(u64),
}

/* Block comment example
   with multiple lines */
#[solana]
struct Config {
    max_players: u32,
    enabled: bool,
    price: f64,
}
""".trimIndent()

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? = null

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = DESCRIPTORS

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName(): String = "LUMOS"

    companion object {
        private val DESCRIPTORS = arrayOf(
            AttributesDescriptor("Keywords//Keyword", LumosSyntaxHighlighter.KEYWORD),
            AttributesDescriptor("Keywords//Storage Modifier", LumosSyntaxHighlighter.MODIFIER),

            AttributesDescriptor("Types//Primitive Type", LumosSyntaxHighlighter.PRIMITIVE_TYPE),
            AttributesDescriptor("Types//Solana Type", LumosSyntaxHighlighter.SOLANA_TYPE),
            AttributesDescriptor("Types//Option Type", LumosSyntaxHighlighter.OPTION_TYPE),
            AttributesDescriptor("Types//Custom Type", LumosSyntaxHighlighter.CUSTOM_TYPE),

            AttributesDescriptor("Attributes//Attribute Brackets", LumosSyntaxHighlighter.ATTRIBUTE_BRACKETS),
            AttributesDescriptor("Attributes//Attribute Name", LumosSyntaxHighlighter.ATTRIBUTE_NAME),

            AttributesDescriptor("Literals//String", LumosSyntaxHighlighter.STRING),
            AttributesDescriptor("Literals//Number", LumosSyntaxHighlighter.NUMBER),

            AttributesDescriptor("Comments//Comment", LumosSyntaxHighlighter.COMMENT),

            AttributesDescriptor("Operators & Punctuation//Operator", LumosSyntaxHighlighter.OPERATOR),
            AttributesDescriptor("Operators & Punctuation//Punctuation", LumosSyntaxHighlighter.PUNCTUATION),
            AttributesDescriptor("Operators & Punctuation//Braces", LumosSyntaxHighlighter.BRACES),
            AttributesDescriptor("Operators & Punctuation//Parentheses", LumosSyntaxHighlighter.PARENTHESES),
            AttributesDescriptor("Operators & Punctuation//Brackets", LumosSyntaxHighlighter.BRACKETS),

            AttributesDescriptor("Identifiers//Identifier", LumosSyntaxHighlighter.IDENTIFIER),
        )
    }
}
