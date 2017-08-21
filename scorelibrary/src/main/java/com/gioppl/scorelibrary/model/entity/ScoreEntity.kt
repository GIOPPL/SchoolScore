package com.gioppl.scorelibrary.model.entity

/**
 * Created by GIOPPL on 2017/8/16.
 */
class ScoreEntity {
    var id:String?=null
    var number:String?=null
    var courseName: String? = null//课程名
    var EnglishName:String?=null//英语名
    var credit: String? = null//学分
    var nature:String?=null//课程属性
    var score: String? = null//成绩
    var reasonOfNoPass:String?=null//未通过原因
    constructor(errorReason:String){
        this.errorReason=errorReason
    }
    constructor(id: String?, number: String?, courseName: String?, EnglishName: String?, credit: String?, nature: String?, score: String?, reasonOfNoPass: String?) {
        this.id = id
        this.number = number
        this.courseName = courseName
        this.EnglishName = EnglishName
        this.credit = credit
        this.nature = nature
        this.score = score
        this.reasonOfNoPass = reasonOfNoPass
    }
    var errorReason:String?=null

}