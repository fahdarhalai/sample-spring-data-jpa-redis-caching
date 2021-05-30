package dev.fahd.springredis.mapper;

import dev.fahd.springredis.dto.EmployeeDTO;
import dev.fahd.springredis.entity.Employee;
import dev.fahd.springredis.mapper.common.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper extends EntityMapper<Employee, EmployeeDTO> {
}
