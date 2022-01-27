package ptc.tech.jet_components.theme


import androidx.compose.ui.graphics.Color

class Colors {
    companion object {
        val PrimaryColor = Color(0xFFBB86FC)
        val SecondaryColor = Color(0xFF6200EE)
    }

    class Button {
        companion object {
            val PrimaryBackgroundColor = Color(0xFFFFCC00)
            val HighlightPrimaryBackgroundColor = Color(0xFFFDBF17)
            val DisableBackgroundColor = Color(0xFFD7D8DB)

            val SecondaryBackgroundColor = Color(0xFF355AD8)
            val HighlightSecondaryBackgroundColor = Color(0xFF2E4CB4)

            val HighlightPrimaryBorderBackgroundColor = Color(0xFFD7D8DB)

            val SecondaryBorderColor = Color(0xFF355AD8)
            val DisableSecondaryBorderColor = Color(0xFF45484A)
            val HighlightSecondaryBorderBackgroundColor = Color(0xFFCFDBFF)


            val TextColorWhite = Color(0xFFFFFFFF)
            val TextColorBlack = Color(0xFF000000)
            val TextColorGray = Color(0xFF45484A)
            val TextColorBlue = Color(0xFF355AD8)
        }
    }

    class TextField {
        companion object {
            val textColor = Color(0xFF000000)
            val disableTextColor = Color(0xFF45484A)
            val borderColor = Color(0xFF9D9EA3)
            val focusBorderColor = Color(0xFF355AD8)
            val errorColor = Color(0xFFCD2026)
            val disableBackgroundColor = Color(0xFFF3F4F8)
        }
    }
}
