package com.ravi.expandablelistview

class HeaderModel(
    var listItem: List<LstHeaderModel>
)

class LstHeaderModel(
    val name: String,
    val childCount: Int,
    val lstSubHeader: List<LstSubHeader>,
    var isExpanded: Boolean = false

)

class LstSubHeader(
    val subHeader: String

)