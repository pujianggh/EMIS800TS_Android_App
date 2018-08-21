package com.android.ts.emis.mode;

import com.libcommon.action.mode.BaseBean;

import java.util.List;

/**
 * @author pujiang
 * @date 2018/8/16 15:19
 * @mail 515210530@qq.com
 * @Description:
 */
public class MessageInfoBean extends BaseBean {


    /**
     * data : {"CurrentPage":1,"TotalPage":1,"TotalCount":1,"UnreadCount":0,"MessageList":[{"BDID":1371178,"MessageType":null,"Title":"工单同步APP失败","Content":"工单：SH233-20180222-0037同步至App失败！","ObjectCode":"SH233-20180222-0037","TicketsStatus":2,"IsRead":1,"Sender":"admin","SendDate":"2018-05-03T11:59:24.99"}]}
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
         * CurrentPage : 1
         * TotalPage : 1.0
         * TotalCount : 1
         * UnreadCount : 0
         * MessageList : [{"BDID":1371178,"MessageType":null,"Title":"工单同步APP失败","Content":"工单：SH233-20180222-0037同步至App失败！","ObjectCode":"SH233-20180222-0037","TicketsStatus":2,"IsRead":1,"Sender":"admin","SendDate":"2018-05-03T11:59:24.99"}]
         */

        private int CurrentPage;
        private double TotalPage;
        private int TotalCount;
        private int UnreadCount;
        private List<MessageListBean> MessageList;

        public int getCurrentPage() {
            return CurrentPage;
        }

        public void setCurrentPage(int CurrentPage) {
            this.CurrentPage = CurrentPage;
        }

        public double getTotalPage() {
            return TotalPage;
        }

        public void setTotalPage(double TotalPage) {
            this.TotalPage = TotalPage;
        }

        public int getTotalCount() {
            return TotalCount;
        }

        public void setTotalCount(int TotalCount) {
            this.TotalCount = TotalCount;
        }

        public int getUnreadCount() {
            return UnreadCount;
        }

        public void setUnreadCount(int UnreadCount) {
            this.UnreadCount = UnreadCount;
        }

        public List<MessageListBean> getMessageList() {
            return MessageList;
        }

        public void setMessageList(List<MessageListBean> MessageList) {
            this.MessageList = MessageList;
        }

        public static class MessageListBean {
            /**
             * BDID : 1371178
             * MessageType : null
             * Title : 工单同步APP失败
             * Content : 工单：SH233-20180222-0037同步至App失败！
             * ObjectCode : SH233-20180222-0037
             * TicketsStatus : 2
             * IsRead : 1
             * Sender : admin
             * SendDate : 2018-05-03T11:59:24.99
             */

            private int BDID;
            private Object MessageType;
            private String Title;
            private String Content;
            private String ObjectCode;
            private int TicketsStatus;
            private int IsRead;
            private String Sender;
            private String SendDate;

            public int getBDID() {
                return BDID;
            }

            public void setBDID(int BDID) {
                this.BDID = BDID;
            }

            public Object getMessageType() {
                return MessageType;
            }

            public void setMessageType(Object MessageType) {
                this.MessageType = MessageType;
            }

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public String getContent() {
                return Content;
            }

            public void setContent(String Content) {
                this.Content = Content;
            }

            public String getObjectCode() {
                return ObjectCode;
            }

            public void setObjectCode(String ObjectCode) {
                this.ObjectCode = ObjectCode;
            }

            public int getTicketsStatus() {
                return TicketsStatus;
            }

            public void setTicketsStatus(int TicketsStatus) {
                this.TicketsStatus = TicketsStatus;
            }

            public int getIsRead() {
                return IsRead;
            }

            public void setIsRead(int IsRead) {
                this.IsRead = IsRead;
            }

            public String getSender() {
                return Sender;
            }

            public void setSender(String Sender) {
                this.Sender = Sender;
            }

            public String getSendDate() {
                return SendDate;
            }

            public void setSendDate(String SendDate) {
                this.SendDate = SendDate;
            }
        }
    }
}
