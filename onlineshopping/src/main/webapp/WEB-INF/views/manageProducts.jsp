<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<div class="row">
		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4 style="color: #fff">Product Management</h4>
				</div>
				<div class="panel-body">
					<!-- 	FORM ELEMENT -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />
								<!-- <em class="help-block">Please Enter Product Name</em> -->
							</div>
						</div>



						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Brand Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="description">Product
								Description</label>
							<div class="col-md-8">
								<sf:textarea type="text" path="description" id="description"
									placeholder="Write a Description" class="form-control"></sf:textarea>
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter
								Unit Price</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Unit Price In &#8377" class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Quantity
								Available</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Quantity Available" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="file">Select
								an Image:</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select
								Category</label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId"
									path="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />

								<!--  Add new Category -->
								<c:if test="${product.id == 0}">
									<div class="text-right">
										<br />
										<button type="button" data-toggle="modal"
											data-target="#myCategoryModel" class="btn btn-warning">
											Add New Category</button>
									</div>
								</c:if>

							</div>
						</div>
						<sf:hidden path="id" />
						<sf:hidden path="code" />
						<sf:hidden path="supplierId" />
						<sf:hidden path="purchases" />
						<sf:hidden path="active" />
						<sf:hidden path="views" />




						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />

							</div>
						</div>

					</sf:form>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-xs-12">
			<h3>Available Products</h3>
			<hr />
		</div>
		<div class="col-xs-12">

			<div class="container-fluid">
				<div class=table-responsive>
					<!--  Product table for Admin   -->

					<table id="productsListTable"
						class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>&#160</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Active</th>
								<th>Edit</th>
							</tr>
						</thead>

						<tfoot>
							<tr>
								<th>Id</th>
								<th>&#160</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Active</th>
								<th>Edit</th>
							</tr>
						</tfoot>

					</table>
				</div>
			</div>


		</div>

	</div>

	<div class="modal fade" id="myCategoryModel" role="dialog"
		tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">

				<!-- Model Header -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title">Add New Category</h4>
				</div>

				<div class="modal-body">
					<!-- Category Form -->
					<sf:form modelAttribute="category" id="categoryForm"
						action="${contextRoot}/manage/category" class="form-horizontal"
						method="POST">
						<div class="form-group">
							<label for="category_name" class="control-label col-md-4">Category
								Name</label>
							<div class="col-md-8 validate">
								<sf:input type="text" path="name" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label for="description" class="control-label col-md-4">Product
								Description</label>
							<div class="col-md-8 validate">
								<sf:textarea cols="" rows="5" type="text" path="description"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" value="Add Category"
									class="btn btn-primary">
							</div>
						</div>

					</sf:form>

				</div>

			</div>
		</div>
	</div>

</div>