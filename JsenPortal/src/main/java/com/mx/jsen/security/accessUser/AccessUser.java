package com.mx.jsen.security.accessUser;

import com.mx.jsen.application.vo.JLoginVO;

public interface AccessUser {
	public JLoginVO obtenerUsuario(Long numero, String pass)throws Exception;
}
