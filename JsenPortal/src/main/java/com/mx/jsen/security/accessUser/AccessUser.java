package com.mx.jsen.security.accessUser;

import com.mx.jsen.application.vo.JLoginVO;

public interface AccessUser {
	public JLoginVO obtenerUsuario(String username, String pass)throws Exception;
}
