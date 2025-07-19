package com.spring.boot.Mini.POS.System.Management.Entity;

import java.util.Objects;

import lombok.Data;

@Data
public class ImportDetailId{

	private Long impCode;
	private Long proCode;

	public ImportDetailId() {
	}

	public ImportDetailId(Long impCode, Long proCode) {
		this.impCode = impCode;
		this.proCode = proCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ImportDetailId))
			return false;
		ImportDetailId that = (ImportDetailId) o;
		return Objects.equals(impCode, that.impCode) && Objects.equals(proCode, that.proCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(impCode, proCode);
	}

}
