package com.core.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author json
 * @since 2018-10-30
 */
@TableName("tbl_user_test")
public class UserTest extends Model<UserTest> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId("test_id")
	private Long testId;
    /**
     * 租户ID
     */
	@TableField("tenant_id")
	private Long tenantId;
    /**
     * 名称
     */
	private String name;
    /**
     * 年龄
     */
	private Integer age;
    /**
     * 测试下划线字段命名类型
     */
	@TableField("test_type")
	private Integer testType;
    /**
     * 日期
     */
	@TableField("test_date")
	private Date testDate;
    /**
     * 测试
     */
	private Long role;
    /**
     * 手机号码
     */
	private String phone;


	public Long getTestId() {
		return testId;
	}

	public UserTest setTestId(Long testId) {
		this.testId = testId;
		return this;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public UserTest setTenantId(Long tenantId) {
		this.tenantId = tenantId;
		return this;
	}

	public String getName() {
		return name;
	}

	public UserTest setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getAge() {
		return age;
	}

	public UserTest setAge(Integer age) {
		this.age = age;
		return this;
	}

	public Integer getTestType() {
		return testType;
	}

	public UserTest setTestType(Integer testType) {
		this.testType = testType;
		return this;
	}

	public Date getTestDate() {
		return testDate;
	}

	public UserTest setTestDate(Date testDate) {
		this.testDate = testDate;
		return this;
	}

	public Long getRole() {
		return role;
	}

	public UserTest setRole(Long role) {
		this.role = role;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public UserTest setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.testId;
	}

}
