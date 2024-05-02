package br.com.leadersofts.qikserve.infrastructure.security.record;

import br.com.leadersofts.qikserve.infrastructure.security.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
