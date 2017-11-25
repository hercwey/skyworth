package boot.entity;

/**
 * Created by zxf on 17/11/13.
 */
public class Asset {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** 主键Id. */
    private Integer id;

    /** 贷款单id. */
    private String loanid;

    /** 贷款金额. */
    private Double loanamount;

    /** planAmount. */
    private Double planamount;

    /** 订单号. */
    private String orderid;

    /** 贷款单状态（正常，已预期，宽限期，展期，已全部退款）. */
    private Byte loanstate;

    /** 贷款单结清状态（未结清，已结清，逾期已结清）. */
    private Byte clearstate;

    /** 订单金额. */
    private Double orderamount;

    /** 还款方式(等额本金、等额本息、按月付息到期还本、一次性还本付息). */
    private Byte repaymentway;

    /** 业务编码(1.BAITIAO,2JINTIAO,3BAOLI). */
    private String businesscode;

    /** 业务名称(1.白条，2,金条，3保理). */
    private String businessname;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoanid() {
        return loanid;
    }

    public void setLoanid(String loanid) {
        this.loanid = loanid;
    }

    public Double getLoanamount() {
        return loanamount;
    }

    public void setLoanamount(Double loanamount) {
        this.loanamount = loanamount;
    }

    public Double getPlanamount() {
        return planamount;
    }

    public void setPlanamount(Double planamount) {
        this.planamount = planamount;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Byte getLoanstate() {
        return loanstate;
    }

    public void setLoanstate(Byte loanstate) {
        this.loanstate = loanstate;
    }

    public Byte getClearstate() {
        return clearstate;
    }

    public void setClearstate(Byte clearstate) {
        this.clearstate = clearstate;
    }

    public Double getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(Double orderamount) {
        this.orderamount = orderamount;
    }

    public Byte getRepaymentway() {
        return repaymentway;
    }

    public void setRepaymentway(Byte repaymentway) {
        this.repaymentway = repaymentway;
    }

    public String getBusinesscode() {
        return businesscode;
    }

    public void setBusinesscode(String businesscode) {
        this.businesscode = businesscode;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }
}
