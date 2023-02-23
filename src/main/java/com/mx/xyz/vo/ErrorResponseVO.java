package com.mx.xyz.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseVO implements Serializable {

	private static final long serialVersionUID = 735090275671833715L;
	private String error;

}
