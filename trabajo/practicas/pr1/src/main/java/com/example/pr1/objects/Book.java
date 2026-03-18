package com.example.pr1.objects;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Book {
    private Long id;
    private String titulo;
    private String autor;
    private int anio;
}
