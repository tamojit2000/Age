package com.ysvg2tafy.age

object functions {
    fun function(min:Long):String {
        val one_year=365*24*60
        val one_month=30*24*60
        val one_day=24*60
        var reqd_year=min/one_year
        var rem=min%one_year
        var reqd_month=rem/one_month
        rem=rem%one_month
        var reqd_day=rem/one_day
        rem=rem%one_day
        var reqd_hr=rem/60
        return "${reqd_year} year ${reqd_month} month ${reqd_day} day ${reqd_hr} hr"
    }

}