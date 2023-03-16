package com.example.mefit.mappers;

import com.example.mefit.models.Goal;
import com.example.mefit.models.dtos.goal.GoalDTO;
import java.sql.Date;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-16T18:52:22+0200",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class GoalMapperImpl extends GoalMapper {

    @Override
    public GoalDTO goalToGoalDTO(Goal goal) {
        if ( goal == null ) {
            return null;
        }

        GoalDTO goalDTO = new GoalDTO();

        goalDTO.setProfiles( map( goal.getProfiles() ) );
        goalDTO.setGoal_id( goal.getGoal_id() );
        goalDTO.setGoal_name( goal.getGoal_name() );
        if ( goal.getStart_date() != null ) {
            goalDTO.setStart_date( new Date( goal.getStart_date().atStartOfDay( ZoneOffset.UTC ).toInstant().toEpochMilli() ) );
        }
        if ( goal.getEnd_date() != null ) {
            goalDTO.setEnd_date( new Date( goal.getEnd_date().atStartOfDay( ZoneOffset.UTC ).toInstant().toEpochMilli() ) );
        }
        goalDTO.setTotal_programs( goal.getTotal_programs() );
        goalDTO.setCompleted_programs( goal.getCompleted_programs() );
        goalDTO.setComplete_goal( goal.isComplete_goal() );

        return goalDTO;
    }

    @Override
    public Collection<GoalDTO> goalToGoalDTO(Collection<Goal> goal) {
        if ( goal == null ) {
            return null;
        }

        Collection<GoalDTO> collection = new ArrayList<GoalDTO>( goal.size() );
        for ( Goal goal1 : goal ) {
            collection.add( goalToGoalDTO( goal1 ) );
        }

        return collection;
    }

    @Override
    public Goal goalDTOToGoal(GoalDTO goalDTO) {
        if ( goalDTO == null ) {
            return null;
        }

        Goal goal = new Goal();

        goal.setProfiles( mapIdsToProfile( goalDTO.getProfiles() ) );
        goal.setGoal_id( goalDTO.getGoal_id() );
        goal.setGoal_name( goalDTO.getGoal_name() );
        if ( goalDTO.getStart_date() != null ) {
            goal.setStart_date( goalDTO.getStart_date().toLocalDate() );
        }
        if ( goalDTO.getEnd_date() != null ) {
            goal.setEnd_date( goalDTO.getEnd_date().toLocalDate() );
        }
        goal.setTotal_programs( goalDTO.getTotal_programs() );
        goal.setCompleted_programs( goalDTO.getCompleted_programs() );
        if ( goalDTO.getComplete_goal() != null ) {
            goal.setComplete_goal( goalDTO.getComplete_goal() );
        }

        return goal;
    }
}
