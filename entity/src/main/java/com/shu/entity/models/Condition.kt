package com.shu.entity.models

import com.shu.entity.ICondition

data class Condition(
    override val text: String?,
    override val icon: String?,
    override val code: Int?
) : ICondition
