<%@ page pageEncoding="UTF-8" isELIgnored="false"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="page-header">
	<h3>Добавление заказа аренды</h3>
</div>

<div class="col-sm-10">
	<ul class="nav nav-tabs">
		<li class="active"><a href="#main-tab" data-toggle="tab">Main <i class="fa"></i></a>
		<li><a href="#cancel-tab" data-toggle="tab">Cancel <i class="fa"></i></a></li>
		<li><a href="#damage-tab" data-toggle="tab">Damage <i class="fa"></i></a></li>
	</ul>
 
	<form id="dealForm" class="form-horizontal" action="/motordepot/page?action=modify_deal" method="post" style="margin-top: 20px;"
			data-bv-trigger="blur"
			data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
			data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
			data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
		<input type="hidden" name="id" value="${deal.id}"/>
		<input type="hidden" id="carPrise" value="${car.prise}"/>
		
		<div class="tab-content">
			<div class="tab-pane active" id="main-tab">
				<div class="form-group">
					<label class="control-label col-sm-2" for="dateFrom">DATE FROM</label>
					<div class="col-sm-3">
						<div class="input-group date" id="dateFromPicker">
							<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
							<input type="datetime" required class="form-control" name="dateFrom" value="${deal.dateFrom}"
								required data-bv-notempty-message="Start date can't be empty">			
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="dateTo">DATE TO</label>
					<div class="col-sm-3">
						<div class="input-group date" id="dateToPicker">
							<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
							<input type="datetime" required class="form-control" name="dateTo" value="${deal.dateTo}"
								required data-bv-notempty-message="End date can't be empty">			
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="bill">BILL</label>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-usd"></i></span>
							<input id="totalBill" type="text" id="bill" readonly class="form-control" name="bill" 
								value="${deal.bill}"/>
						</div>				
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="bill">CAR MODEL</label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-road"></i></span>
							<input type="text" readonly class="form-control" 
								name="model" value="${car.model}">				
						</div>
					</div>
				</div>				
			</div>
			
			<div class="tab-pane" id="cancel-tab">
				<div class="form-group">
					<label class="control-label col-sm-2" for="description">DESCRIPTION</label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
							<textarea rows="5" class="form-control" name="description"
								required data-bv-notempty-message="Desctiption can't be empty"></textarea>
						</div>
					</div>
				</div>
			</div>
			
			<div class="tab-pane" id="damage-tab">
				<div class="form-group">
					<label class="control-label col-sm-2" for="damage_bill">BILL DAMAGE</label>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-usd"></i></span>
							<input id="totalBill" type="text" id="damage_bill" class="form-control" name="damage_bill" 
								value="${deal.damage.bill}"/>
						</div>				
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="damage_description">DESCRIPTION</label>
					<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
							<textarea rows="5" class="form-control" name="damage_description"></textarea>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button class="btn btn-primary"><fmt:message key="prop.form.button.save"/></button>
				<button class="btn btn-default" onclick="goback(); return false;"><fmt:message key="prop.form.button.cancel"/></button>
			</div>
		</div> 
	</form>
</div>	


