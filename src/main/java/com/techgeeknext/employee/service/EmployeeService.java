package com.techgeeknext.employee.service;

import com.techgeeknext.constants.Role;
import com.techgeeknext.employee.EmployeeRequest;
import com.techgeeknext.employee.EmployeeResponse;
import com.techgeeknext.employee.EmployeeServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class EmployeeService extends EmployeeServiceGrpc.EmployeeServiceImplBase {

    /**
     * Unary operation to get the employee based on employee id
     * @param request
     * @param responseObserver
     */
    @Override
    public void getEmployee(EmployeeRequest request,
                            StreamObserver<EmployeeResponse> responseObserver) {

        //call repository to load the data from database
        //we have added static data for example
        EmployeeResponse empResp = EmployeeResponse
                .newBuilder()
                .setEmpId(request.getEmpId())
                .setName("abc")
                .setRole(Role.USER)
                .build();

        //set the response object
        responseObserver.onNext(empResp);

        //mark process is completed
        responseObserver.onCompleted();
    }
}
