package com.desafio.tipocambio.controller;

import com.desafio.tipocambio.model.TipoCambioResponse;
import com.desafio.tipocambio.model.TokenInfo;
import com.desafio.tipocambio.model.Usuario;
import com.desafio.tipocambio.service.Impl.JwtUtilService;
import com.desafio.tipocambio.service.TipoCambioService;
import com.desafio.tipocambio.service.TipoCambioValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TipoCambioController {

    @Autowired
    private TipoCambioService tipoCambioService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private TipoCambioValidationService tipoCambioValidationService;

    @Autowired
    private JwtUtilService jwtUtilService;

    @GetMapping("/tipocambio")
    public ResponseEntity<Map<String, Object>> getTipoCambio(
            @RequestParam(value = "origen") String monedaOrigen,
            @RequestParam(value = "destino") String monedaDestino,
            @RequestParam(value = "monto") Double monto) throws RuntimeException {

        tipoCambioValidationService.validateParametersTipoCambio(monto,monedaOrigen,monedaDestino);

        return new ResponseEntity<>(tipoCambioService.getTipoDeCambioxTipos(monto,monedaOrigen,monedaDestino), HttpStatus.ACCEPTED) ;
    }

    @GetMapping("/obtenerToken")
    public ResponseEntity<TokenInfo> obtenerToken(@RequestBody Usuario usuario){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getUsuario(),
                        usuario.getClave()));

        System.out.println("ingreso correctamente");
        UserDetails userDetails = userDetailsService.loadUserByUsername(
                usuario.getUsuario());

        String jwt = jwtUtilService.generateToken(userDetails);

        TokenInfo tokenInfo = new TokenInfo(jwt);

        return ResponseEntity.ok(tokenInfo);
    }
}
