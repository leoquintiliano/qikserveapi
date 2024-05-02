package br.com.leadersofts.qikserve.infrastructure.security.record;

import java.util.List;

public record LoginResponseDTO(String token, String username, List<String> authorities) {
}
