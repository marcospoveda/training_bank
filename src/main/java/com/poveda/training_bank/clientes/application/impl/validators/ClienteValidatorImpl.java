package com.poveda.training_bank.clientes.application.impl.validators;

import com.poveda.training_bank.clientes.domain.model.Cliente;
import com.poveda.training_bank.clientes.domain.model.ClienteValidator;
import com.poveda.training_bank.infrastructure.exceptions.ValidationException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ClienteValidatorImpl implements ClienteValidator {


    public boolean supports(Class<?> aClass) {
        return Cliente.class.equals(aClass);
    }


    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "nome", "nome.empty");
        Cliente c = (Cliente) o;
    }


    private Map<String, CheckRule> rules = new HashMap<>();

    {
        rules.put("ID do cliente é obrigatório", cliente -> cliente.getIdCliente() == null);
        rules.put("Nome do cliente é requerido", cliente -> cliente.getNome() == null);
        rules.put("Endereço do cliente é requerido", cliente -> cliente.getEndereco() == null);
        rules.put("Telefone do cliente é requerido", cliente -> cliente.getTelefone() == null || cliente.getTelefone() <= 0);
        rules.put("RG do cliente é requerido", cliente -> cliente.getRg() == null);
        rules.put("CPF do cliente é requerido", cliente -> cliente.getCpf() == null || cliente.getCpf() <= 0);
        rules.put("Email do cliente é requerido", cliente -> cliente.getEmail() == null);
       // rules.put("Conta do cliente é obrigatória", cliente -> cliente.getConta() == null);
    }

    @Override
    public void checkRules(Cliente cliente) {
        Set<String> violations = rules.entrySet()
                .stream()
                .filter(rule -> rule.getValue().check(cliente))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        if (!violations.isEmpty()){
            throw new ValidationException(violations.toString());
        }
    }

    private interface CheckRule {
        Boolean check(Cliente cliente);
    }

}