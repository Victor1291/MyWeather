package com.shu.entity

interface IAstro {

    var sunrise          : String?
    var sunset           : String?
    var moonrise         : String?
    var moonset          : String?
    var moonPhase        : String?
    var moonIllumination : Double?
    var isMoonUp         : Int?
    var isSunUp          : Int?
}