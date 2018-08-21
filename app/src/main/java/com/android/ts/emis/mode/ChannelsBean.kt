package com.android.ts.emis.mode

import com.libcommon.action.mode.BaseBean
import java.io.Serializable

/**
 * 渠道获取-Mode
 *
 * @author pujiang
 * @date 2017-10-29 14:31
 * @mail 515210530@qq.com
 * @Description:
 */
class ChannelsBean : BaseBean(), Serializable {
    var body: BodyBean? = null

    class BodyBean : Serializable {
        var offset: Int = 0
        var page: Int = 0
        var size: Int = 0
        var total: Int = 0
        var totalPages: Int = 0

        var data: List<DataBean>? = null

        class DataBean : Serializable {
            var applyNeed: String? = null
            var applyQualification: String? = null
            var channelApplyUrl: String? = null
            var channelDayRate: Double = 0.toDouble()
            var channelId: Int = 0
            var channelIshot: Int = 0
            var channelIsrecom: Int = 0
            var channelLoan: String? = null
            var channelLoanCycle: String? = null
            var channelLoanLast: Int = 0
            var channelName: String? = null
            var channelPicUrl: String? = null
            var channelRemark: String? = null
            var channelRepayment: Double = 0.toDouble()
            var createTime: String? = null
            var operateId: Int = 0
            var operateName: String? = null
            var updateTime: String? = null
        }
    }
}
