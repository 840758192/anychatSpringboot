package com.anychat.org.model.base;

import java.io.Serializable;
import java.util.Date;

public class Chat implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat.chat_id
     *
     * @mbg.generated
     */
    private String chatId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat.chat_content
     *
     * @mbg.generated
     */
    private String chatContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat.from_user_id
     *
     * @mbg.generated
     */
    private String fromUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat.to_type
     *
     * @mbg.generated
     */
    private Byte toType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat.to_type_id
     *
     * @mbg.generated
     */
    private String toTypeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat.chat_state
     *
     * @mbg.generated
     */
    private Byte chatState;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat.chat_type
     *
     * @mbg.generated
     */
    private Byte chatType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat.chat_create_time
     *
     * @mbg.generated
     */
    private Date chatCreateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table chat
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat.chat_id
     *
     * @return the value of chat.chat_id
     *
     * @mbg.generated
     */
    public String getChatId() {
        return chatId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat.chat_id
     *
     * @param chatId the value for chat.chat_id
     *
     * @mbg.generated
     */
    public void setChatId(String chatId) {
        this.chatId = chatId == null ? null : chatId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat.chat_content
     *
     * @return the value of chat.chat_content
     *
     * @mbg.generated
     */
    public String getChatContent() {
        return chatContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat.chat_content
     *
     * @param chatContent the value for chat.chat_content
     *
     * @mbg.generated
     */
    public void setChatContent(String chatContent) {
        this.chatContent = chatContent == null ? null : chatContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat.from_user_id
     *
     * @return the value of chat.from_user_id
     *
     * @mbg.generated
     */
    public String getFromUserId() {
        return fromUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat.from_user_id
     *
     * @param fromUserId the value for chat.from_user_id
     *
     * @mbg.generated
     */
    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId == null ? null : fromUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat.to_type
     *
     * @return the value of chat.to_type
     *
     * @mbg.generated
     */
    public Byte getToType() {
        return toType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat.to_type
     *
     * @param toType the value for chat.to_type
     *
     * @mbg.generated
     */
    public void setToType(Byte toType) {
        this.toType = toType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat.to_type_id
     *
     * @return the value of chat.to_type_id
     *
     * @mbg.generated
     */
    public String getToTypeId() {
        return toTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat.to_type_id
     *
     * @param toTypeId the value for chat.to_type_id
     *
     * @mbg.generated
     */
    public void setToTypeId(String toTypeId) {
        this.toTypeId = toTypeId == null ? null : toTypeId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat.chat_state
     *
     * @return the value of chat.chat_state
     *
     * @mbg.generated
     */
    public Byte getChatState() {
        return chatState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat.chat_state
     *
     * @param chatState the value for chat.chat_state
     *
     * @mbg.generated
     */
    public void setChatState(Byte chatState) {
        this.chatState = chatState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat.chat_type
     *
     * @return the value of chat.chat_type
     *
     * @mbg.generated
     */
    public Byte getChatType() {
        return chatType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat.chat_type
     *
     * @param chatType the value for chat.chat_type
     *
     * @mbg.generated
     */
    public void setChatType(Byte chatType) {
        this.chatType = chatType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat.chat_create_time
     *
     * @return the value of chat.chat_create_time
     *
     * @mbg.generated
     */
    public Date getChatCreateTime() {
        return chatCreateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat.chat_create_time
     *
     * @param chatCreateTime the value for chat.chat_create_time
     *
     * @mbg.generated
     */
    public void setChatCreateTime(Date chatCreateTime) {
        this.chatCreateTime = chatCreateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Chat other = (Chat) that;
        return (this.getChatId() == null ? other.getChatId() == null : this.getChatId().equals(other.getChatId()))
            && (this.getChatContent() == null ? other.getChatContent() == null : this.getChatContent().equals(other.getChatContent()))
            && (this.getFromUserId() == null ? other.getFromUserId() == null : this.getFromUserId().equals(other.getFromUserId()))
            && (this.getToType() == null ? other.getToType() == null : this.getToType().equals(other.getToType()))
            && (this.getToTypeId() == null ? other.getToTypeId() == null : this.getToTypeId().equals(other.getToTypeId()))
            && (this.getChatState() == null ? other.getChatState() == null : this.getChatState().equals(other.getChatState()))
            && (this.getChatType() == null ? other.getChatType() == null : this.getChatType().equals(other.getChatType()))
            && (this.getChatCreateTime() == null ? other.getChatCreateTime() == null : this.getChatCreateTime().equals(other.getChatCreateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChatId() == null) ? 0 : getChatId().hashCode());
        result = prime * result + ((getChatContent() == null) ? 0 : getChatContent().hashCode());
        result = prime * result + ((getFromUserId() == null) ? 0 : getFromUserId().hashCode());
        result = prime * result + ((getToType() == null) ? 0 : getToType().hashCode());
        result = prime * result + ((getToTypeId() == null) ? 0 : getToTypeId().hashCode());
        result = prime * result + ((getChatState() == null) ? 0 : getChatState().hashCode());
        result = prime * result + ((getChatType() == null) ? 0 : getChatType().hashCode());
        result = prime * result + ((getChatCreateTime() == null) ? 0 : getChatCreateTime().hashCode());
        return result;
    }
}