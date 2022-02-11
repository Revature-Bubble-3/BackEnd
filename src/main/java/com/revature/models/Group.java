package com.revature.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.revature.utilites.SecurityUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "groups")
@Data
@AllArgsConstructor
@EqualsAndHashCode(exclude = { "members" })
@ToString(exclude = { "members" })
public class Group {

	@Id
	private Integer groupId;
	
	@Column(name="group_name", nullable=false, unique=true)
	private String groupName;

	@ManyToOne
	private Profile owner;

	@ManyToMany
	@JoinTable(name = "profile_groups", joinColumns = @JoinColumn(name = "group_id"), inverseJoinColumns = @JoinColumn(name = "profile_id"))
	private Set<Profile> members = new HashSet<>();

	public Group() {
		super();
		groupId = SecurityUtil.getId();
	}
	
	public Set<Profile> getMembers() {
		return members;
	}
}
