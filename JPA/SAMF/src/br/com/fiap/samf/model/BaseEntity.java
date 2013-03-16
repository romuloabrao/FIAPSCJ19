
package br.com.fiap.samf.model;

import java.io.Serializable;

public interface BaseEntity<Key extends Object> extends Serializable {
	public Key getCodigo();
}
