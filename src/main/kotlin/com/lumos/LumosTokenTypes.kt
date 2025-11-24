package com.lumos

import com.intellij.psi.tree.IElementType
import com.intellij.psi.TokenType

/**
 * Token types for LUMOS language elements.
 * Based on the VS Code TextMate grammar.
 */
object LumosTokenTypes {
    // Keywords
    val KEYWORD = IElementType("LUMOS_KEYWORD", LumosLanguage)
    val STORAGE_MODIFIER = IElementType("LUMOS_STORAGE_MODIFIER", LumosLanguage)

    // Types
    val PRIMITIVE_TYPE = IElementType("LUMOS_PRIMITIVE_TYPE", LumosLanguage)
    val SOLANA_TYPE = IElementType("LUMOS_SOLANA_TYPE", LumosLanguage)
    val OPTION_TYPE = IElementType("LUMOS_OPTION_TYPE", LumosLanguage)
    val CUSTOM_TYPE = IElementType("LUMOS_CUSTOM_TYPE", LumosLanguage)

    // Attributes
    val ATTRIBUTE_START = IElementType("LUMOS_ATTRIBUTE_START", LumosLanguage)
    val ATTRIBUTE_NAME = IElementType("LUMOS_ATTRIBUTE_NAME", LumosLanguage)
    val ATTRIBUTE_END = IElementType("LUMOS_ATTRIBUTE_END", LumosLanguage)

    // Literals
    val STRING = IElementType("LUMOS_STRING", LumosLanguage)
    val NUMBER = IElementType("LUMOS_NUMBER", LumosLanguage)
    val HEX_NUMBER = IElementType("LUMOS_HEX_NUMBER", LumosLanguage)
    val BINARY_NUMBER = IElementType("LUMOS_BINARY_NUMBER", LumosLanguage)
    val OCTAL_NUMBER = IElementType("LUMOS_OCTAL_NUMBER", LumosLanguage)

    // Comments
    val LINE_COMMENT = IElementType("LUMOS_LINE_COMMENT", LumosLanguage)
    val BLOCK_COMMENT = IElementType("LUMOS_BLOCK_COMMENT", LumosLanguage)

    // Operators and punctuation
    val OPERATOR = IElementType("LUMOS_OPERATOR", LumosLanguage)
    val COMMA = IElementType("LUMOS_COMMA", LumosLanguage)
    val SEMICOLON = IElementType("LUMOS_SEMICOLON", LumosLanguage)
    val COLON = IElementType("LUMOS_COLON", LumosLanguage)
    val LBRACE = IElementType("LUMOS_LBRACE", LumosLanguage)
    val RBRACE = IElementType("LUMOS_RBRACE", LumosLanguage)
    val LPAREN = IElementType("LUMOS_LPAREN", LumosLanguage)
    val RPAREN = IElementType("LUMOS_RPAREN", LumosLanguage)
    val LBRACKET = IElementType("LUMOS_LBRACKET", LumosLanguage)
    val RBRACKET = IElementType("LUMOS_RBRACKET", LumosLanguage)
    val LT = IElementType("LUMOS_LT", LumosLanguage)
    val GT = IElementType("LUMOS_GT", LumosLanguage)

    // Identifiers
    val IDENTIFIER = IElementType("LUMOS_IDENTIFIER", LumosLanguage)

    // Whitespace
    val WHITESPACE = TokenType.WHITE_SPACE

    // Bad character
    val BAD_CHARACTER = TokenType.BAD_CHARACTER

    // Token sets for easier grouping
    val KEYWORDS = setOf("struct", "enum", "use", "pub", "type", "const")
    val STORAGE_MODIFIERS = setOf("pub", "mut")
    val PRIMITIVE_TYPES = setOf(
        "u8", "u16", "u32", "u64", "u128",
        "i8", "i16", "i32", "i64", "i128",
        "f32", "f64", "bool", "String"
    )
    val SOLANA_TYPES = setOf("PublicKey", "Pubkey", "Signature", "Keypair")
    val OPTION_TYPES = setOf("Option", "Vec")
    val ATTRIBUTE_NAMES = setOf("solana", "account", "key", "max", "deprecated", "version")
}
