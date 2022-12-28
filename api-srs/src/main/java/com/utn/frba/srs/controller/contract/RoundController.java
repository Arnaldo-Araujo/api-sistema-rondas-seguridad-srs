package com.utn.frba.srs.controller.contract;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/v1/srs/round")
interface RoundController {

	record RoundDto() {
	}

	record RoundReduceDto() {
	}

	@PostMapping
	Long create(@RequestBody RoundController.RoundDto request);

	@PutMapping("/{roundId}")
	void update(@PathVariable("roundId") Long roundId, @RequestBody RoundController.RoundDto request);

	@DeleteMapping("/{roundId}")
	void delete(@PathVariable("roundId") Long roundId);

	@GetMapping("/findBySubsidiary/{subsidiaryId}")
	List<RoundController.RoundReduceDto> findBySubsidiary(@PathVariable("subsidiaryId") Long subsidiaryId);

	@GetMapping("/findByCustomer/{customerId}")
	List<RoundController.RoundReduceDto> findByCustomer(@PathVariable("customerId") Long customerId);

	@GetMapping("/findById/{roundId}")
	RoundController.RoundReduceDto findById(@PathVariable("roundId") Long roundId);


}
