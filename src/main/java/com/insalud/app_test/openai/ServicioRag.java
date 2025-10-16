package com.insalud.app_test.openai;

import java.util.List;
import java.util.Map;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import com.insalud.app_test.entidad.Empleado;
import com.insalud.app_test.entidad.Paciente;
import com.insalud.app_test.entidad.Persona;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServicioRag {

    private final VectorStore vectorStore;

    public void guardarPacienteVector(Persona persona, Paciente paciente) {
        Document doc = Document.builder()
            .id(String.valueOf(persona.getId_persona()))
            .text(persona.getNombre())
            .metadata(Map.of(
                        "id_persona", persona.getId_persona(),
                        "nombre", persona.getNombre(),
                        "email", persona.getEmail(),
                        "estado", persona.getEstado(),
                        "rol", paciente.getRol()
                ))
                .build();
        vectorStore.add(List.of(doc));
    }

    public void guardarEmpleadoVector(Persona persona, Empleado empleado) {
        Document doc = Document.builder()
            .id(String.valueOf(persona.getId_persona()))
            .text(persona.getNombre())
            .metadata(Map.of(
                        "id_persona", persona.getId_persona(),
                        "nombre", persona.getNombre(),
                        "email", persona.getEmail(),
                        "estado", persona.getEstado(),
                        "rol", empleado.getRol(),
                        "especialidad", empleado.getEspecialidades()
                ))
                .build();
        vectorStore.add(List.of(doc));
    }
}
