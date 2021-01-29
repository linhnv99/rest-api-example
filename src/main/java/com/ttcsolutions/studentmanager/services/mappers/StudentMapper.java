package com.ttcsolutions.studentmanager.services.mappers;

import com.ttcsolutions.studentmanager.models.entities.ClassEntity;
import com.ttcsolutions.studentmanager.models.entities.StudentEntity;
import com.ttcsolutions.studentmanager.models.in.StudentIn;
import com.ttcsolutions.studentmanager.models.out.ClassDTO;
import com.ttcsolutions.studentmanager.models.out.StudentDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper {

    public List<StudentDTO> toDTOs(List<StudentEntity> studentEntities) {
        return studentEntities.stream()
                .map(s -> {
                    StudentDTO studentDTO = new StudentDTO();
                    studentDTO.setId(s.getId());
                    studentDTO.setName(s.getName());
                    studentDTO.setPhone(s.getPhone());
                    studentDTO.setAddress(s.getAddress());
                    studentDTO.setBirthday(s.getBirthday());
                    ClassDTO classDTO = null;
                    if (s.getClassEntity() != null) {
                        classDTO = new ClassDTO();
                        classDTO.setId(s.getClassEntity().getId());
                        classDTO.setName(s.getClassEntity().getName());
                    }
                    studentDTO.setClassDTO(classDTO);
                    return studentDTO;
                }).collect(Collectors.toList());
    }

    public StudentEntity toEntity(StudentIn studentIn, ClassEntity classEntity) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(studentIn.getName());
        studentEntity.setAddress(studentIn.getAddress());
        studentEntity.setBirthday(studentIn.getBirthday());
        studentEntity.setPhone(studentIn.getPhone());
        studentEntity.setClassEntity(classEntity);
        return studentEntity;
    }

    public StudentEntity toEntity(int id, StudentIn studentIn, ClassEntity classEntity) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(id);
        studentEntity.setName(studentIn.getName());
        studentEntity.setAddress(studentIn.getAddress());
        studentEntity.setBirthday(studentIn.getBirthday());
        studentEntity.setPhone(studentIn.getPhone());
        studentEntity.setClassEntity(classEntity);
        return studentEntity;
    }

    public StudentDTO toDTO(StudentEntity studentEntity) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentEntity.getId());
        studentDTO.setName(studentEntity.getName());
        studentDTO.setAddress(studentEntity.getAddress());
        studentDTO.setBirthday(studentEntity.getBirthday());
        studentDTO.setPhone(studentEntity.getPhone());
        ClassDTO classDTO = new ClassDTO();
        classDTO.setId(studentEntity.getClassEntity().getId());
        classDTO.setName(studentEntity.getClassEntity().getName());
        studentDTO.setClassDTO(classDTO);
        return studentDTO;
    }
}
