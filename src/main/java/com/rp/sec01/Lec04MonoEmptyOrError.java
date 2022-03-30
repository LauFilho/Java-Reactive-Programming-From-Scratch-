package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {
    public static void main(String[] args) {

        // userid = 1 - Cenário de Sucesso (Mono.just)
        // userid = 2 - Cenário de Vazio (Mono.just)
        // userid = 3 - Cenário de Tratamento de Erro (Mono.error)
        userMonoRepository(1).subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }

    private static Mono<String> userMonoRepository(int userId) {

        if (userId == 1) {
            return Mono.just(Util.faker().name().firstName());
        } else if (userId == 2) {
            return Mono.empty();// Mono Empty, forma de representar o null no cenário não bloqueante
        } else {
            return Mono.error(new RuntimeException("Usuário não mapeado"));

        }
    }
}
