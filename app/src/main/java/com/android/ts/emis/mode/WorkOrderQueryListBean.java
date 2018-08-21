package com.android.ts.emis.mode;

import com.libcommon.action.mode.BaseBean;

import java.util.List;

/**
 * @author pujiang
 * @date 2018/8/16 15:19
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderQueryListBean extends BaseBean {

    /**
     * data : {"CurrentPageIndex":1,"TotalPage":4,"TotalCount":63,"TicketsList":[{"TicketsCode":"XA234-20180214-0026","TicketsStatus":1,"TicketsStatusName":"已派工","CreateDate":"2018/2/14 10:09:53","TicketsDescription":"","PriorityCode":"20150414170730110785","PriorityName":"1普通"},{"TicketsCode":"XA234-20180214-0027","TicketsStatus":1,"TicketsStatusName":"已派工","CreateDate":"2018/2/14 10:15:26","TicketsDescription":"","PriorityCode":"20150414170730110785","PriorityName":"1普通"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * CurrentPageIndex : 1
         * TotalPage : 4
         * TotalCount : 63
         * TicketsList : [{"TicketsCode":"XA234-20180214-0026","TicketsStatus":1,"TicketsStatusName":"已派工","CreateDate":"2018/2/14 10:09:53","TicketsDescription":"","PriorityCode":"20150414170730110785","PriorityName":"1普通"},{"TicketsCode":"XA234-20180214-0027","TicketsStatus":1,"TicketsStatusName":"已派工","CreateDate":"2018/2/14 10:15:26","TicketsDescription":"","PriorityCode":"20150414170730110785","PriorityName":"1普通"}]
         */

        private int CurrentPageIndex;
        private int TotalPage;
        private int TotalCount;
        private List<TicketInfoBean> TicketsList;

        public int getCurrentPageIndex() {
            return CurrentPageIndex;
        }

        public void setCurrentPageIndex(int CurrentPageIndex) {
            this.CurrentPageIndex = CurrentPageIndex;
        }

        public int getTotalPage() {
            return TotalPage;
        }

        public void setTotalPage(int TotalPage) {
            this.TotalPage = TotalPage;
        }

        public int getTotalCount() {
            return TotalCount;
        }

        public void setTotalCount(int TotalCount) {
            this.TotalCount = TotalCount;
        }

        public List<TicketInfoBean> getTicketsList() {
            return TicketsList;
        }

        public void setTicketsList(List<TicketInfoBean> ticketsList) {
            TicketsList = ticketsList;
        }
    }
}
