package com.lehang.demo.demo01.appuser;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Date;

/**
 * JWT响应
 */
@Data
@AllArgsConstructor
@Builder
public class JwtResponse implements Serializable {
	private String token;
	private UserDetails userDetails;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date lastLoginDate;
	private String error;
}